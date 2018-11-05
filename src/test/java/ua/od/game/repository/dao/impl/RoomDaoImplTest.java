package ua.od.game.repository.dao.impl;


import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.RoomEntity;
import ua.od.game.repository.dao.DbTest;
import ua.od.game.repository.dao.RoomDao;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author ruslan.gramatic
 */
public class RoomDaoImplTest extends DbTest {
    RoomDao roomDao;

    @Before
    public void init() {
        roomDao = new RoomDaoImpl();
    }

    @Test
    public void getRoomListTest() {
        List<RoomEntity> rooms = roomDao.getRoomList();
        assertNotNull(rooms);
        assertTrue(rooms.size() > 0);
    }
}
