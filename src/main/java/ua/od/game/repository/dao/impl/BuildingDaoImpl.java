package ua.od.game.repository.dao.impl;

import ua.od.game.model.BuildingEntity;
import ua.od.game.repository.dao.BuildingDao;
import ua.od.game.repository.helper.SqlHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;

public class BuildingDaoImpl implements BuildingDao {

    @Override
    public List<BuildingEntity> getAllBuildingList() {
        String sqlQuery;
        sqlQuery = "SELECT  distinct a.id, a.name, a.description, " +
                "b.resource_id, b.number_per_sec  from Building a " +
                "inner join Building_Product b " +
                "on a.id = b.building_id order by a.id,b.resource_id ASC";
        return SqlHelper.prepareStatement(sqlQuery, pstmt -> {
            ResultSet rs = pstmt.executeQuery();
            Integer idBuilding;
            Integer idResource;
            Float numberPerSec;
            List<BuildingEntity> buildings = new LinkedList<>();
            BuildingEntity build = null;
            while (rs.next()) {
                idBuilding = rs.getInt("id");
                if(build == null) {
                    build = createBuildingEntity(rs);
                }
                else {
                    if(!build.getId().equals(idBuilding)) {
                        buildings.add(build);
                        build = createBuildingEntity(rs);
                    }
                }
                Map<Integer,Float> listBuildingResources = build.getResource();
                idResource = rs.getInt("resource_id");
                numberPerSec = rs.getFloat("number_per_sec");
                listBuildingResources.put(idResource, numberPerSec);
                build.setResource(listBuildingResources);
            }
            buildings.add(build);
            return buildings;
        });
    }

    private BuildingEntity createBuildingEntity(ResultSet rs) throws SQLException {
        return new BuildingEntity(){{
            setId(rs.getInt("id"));
            setName(rs.getString("name"));
            setDescription(rs.getString("description"));
            setResource(new LinkedHashMap<>());
        }};
    }
}
