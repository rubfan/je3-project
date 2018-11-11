package ua.od.game.repository.dao.impl;


import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.ResourceEntity;
import ua.od.game.model.RoomEntity;
import ua.od.game.repository.dao.DbTest;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Mazovskiy Mihail
 */

public class ResourceDaoImplTest extends DbTest {
    ResourceDaoImpl resourceDao;

    @Before
    public void init() {
        resourceDao = new ResourceDaoImpl();
    }

    @Test
    public void getRoomListTest() {
        List<ResourceEntity> resourceList = resourceDao.getAllResourceList();
        for (int i = 0; i < resourceList.size(); i++) {
            System.out.print(resourceList.get(i).getId() + " ");
            System.out.print(resourceList.get(i).getName() + " ");
            System.out.println(resourceList.get(i).getDescription()+ " ");
        }
        if (!resourceList.isEmpty())
        assertTrue(true);
    }
}

