package ua.od.game.repository.dao.impl;

import ua.od.game.model.ResourcesEntity;
import ua.od.game.repository.dao.ResourceDao;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class ResourceDaoImpl implements ResourceDao {


    public List<ResourcesEntity> getAllResourceList() {
        return SqlHelper.createStatement(statement -> {
        ResultSet resultSet = statement.executeQuery("SELECT id, name, description FROM Resources");
        List<ResourcesEntity> resourcesEntities = new LinkedList<>();
        while (resultSet.next()){
        resourcesEntities.add(new ResourcesEntity(){{
            setId(resultSet.getInt("id"));
            setName(resultSet.getString("name"));
            setDescription(resultSet.getString("description"));
        }});
        }
        return resourcesEntities;
        });
    }
}



