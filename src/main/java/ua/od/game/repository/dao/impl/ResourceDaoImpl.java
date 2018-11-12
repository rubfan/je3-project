package ua.od.game.repository.dao.impl;

import ua.od.game.model.ResourceEntity;
import ua.od.game.repository.dao.ResourceDao;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class ResourceDaoImpl implements ResourceDao {


    public List<ResourceEntity> getAllResourceList() {
        return SqlHelper.prepareStatement("SELECT * FROM resource" ,(resourceStatement -> {
            ResultSet resultSet = resourceStatement.executeQuery();
            List<ResourceEntity> resourcesEntities = new LinkedList<>();
            while (resultSet.next()){
                resourcesEntities.add(new ResourceEntity(){{
                    setId(resultSet.getInt("id"));
                    setName(resultSet.getString("name"));
                    setDescription(resultSet.getString("description"));

                }});
            }
        return resourcesEntities;
        }));
    }
}



