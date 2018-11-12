package ua.od.game.repository.dao.impl;

import ua.od.game.model.BuildingEntity;
import ua.od.game.model.ResourceEntity;
import ua.od.game.repository.dao.BuildingDao;
import ua.od.game.repository.helper.SqlHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;

public class BuildingDaoImpl implements BuildingDao {

    @Override
    public Map<BuildingEntity, Map<ResourceEntity,Float>> getAllBuildingList() {
        return SqlHelper.prepareStatement("SELECT   id, name, description from Building", pstmt -> {
            ResultSet rs = pstmt.executeQuery();
            Map<BuildingEntity,Map<ResourceEntity,Float>> map = new LinkedHashMap<>();
            while(rs.next()) {
                Integer id = rs.getInt("id");
                map.put(
                        new BuildingEntity(){{
                            setId(id);
                            setName(rs.getString("name"));
                            setDescription(rs.getString("description"));
                        }},
                        SqlHelper.prepareStatement("select  resource_id, number_per_sec " +
                                "from Building_Product where building_id = ?", pstmt1 ->{
                            pstmt1.setInt(1, id);
                            ResultSet rs1 = pstmt1.executeQuery();
                            ResourceDaoImpl resource = new ResourceDaoImpl();
                            List<ResourceEntity> listResource;
                            listResource = resource.getAllResourceList();
                            Map<ResourceEntity,Float> mapResource = new LinkedHashMap<>();
                            while(rs1.next()) {
                                listResource.forEach(listRes -> {
                                    try {
                                        if(listRes.getId().equals(rs1.getInt("resource_id"))) {
                                            mapResource.put(listRes,rs1.getFloat("number_per_sec"));
                                        }
                                    } catch (SQLException e) {
                                        System.out.println(e.toString());
                                    }
                                });
                            }
                            return mapResource;
                        })
                );
            }
            return map;
        });
    }
}
