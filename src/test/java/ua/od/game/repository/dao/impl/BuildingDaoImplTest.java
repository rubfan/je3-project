package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.BuildingEntity;
import ua.od.game.model.ResourceEntity;
import ua.od.game.repository.dao.BuildingDao;
import ua.od.game.repository.dao.DbTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BuildingDaoImplTest extends DbTest {

    BuildingDaoImpl buildingDao;

    @Before
    public void init() {
        buildingDao = new BuildingDaoImpl();
    }

    @Test
    public void getAllBuildingListTest() {
       List<BuildingEntity> list = new LinkedList<>();
       list = buildingDao.getAllBuildingList();
       list.forEach(buildings ->{
           buildings.getResource().forEach((resources, number) -> {
               assertTrue(number != 0);
           });
       });
    }
}
