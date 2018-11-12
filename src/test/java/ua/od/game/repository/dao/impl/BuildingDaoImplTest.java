package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.BuildingEntity;
import ua.od.game.model.ResourceEntity;
import ua.od.game.repository.dao.BuildingDao;
import ua.od.game.repository.dao.DbTest;

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
        Map<BuildingEntity, Map<ResourceEntity,Float>> map = buildingDao.getAllBuildingList();
        System.out.println(map.size());
        map.forEach((map1,list1) -> {
            System.out.println(map1.toString());
            list1.forEach((resource,resPerSeq) ->{
            System.out.println("\t" + resource.toString() + "number_per_sec = " + resPerSeq);
            });
            System.out.println();
        });
        map.forEach((map1,list1) -> {
            list1.forEach((list,resPerSec) -> {
                assertTrue(resPerSec != 0);
            });

        });
    }
}
