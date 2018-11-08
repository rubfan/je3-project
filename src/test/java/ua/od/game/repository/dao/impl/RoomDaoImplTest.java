package ua.od.game.repository.dao.impl;


import org.junit.Before;
import org.junit.Test;

import ua.od.game.model.RoomEntity;
import ua.od.game.repository.dao.DbTest;
import ua.od.game.repository.dao.RoomDao;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


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
        for (int i = 0; i < rooms.size(); i++) {
            System.out.print(rooms.get(i).getId() + " ");
            System.out.print(rooms.get(i).getName() + " ");
            System.out.print(rooms.get(i).getDescription()+ " ");
            System.out.print(rooms.get(i).getUser1Name()+ " ");
            System.out.println(rooms.get(i).getUser2Name()+ " ");
        }
        assertTrue(true);
    }
    @Test
    public void enterRoomTest1() {
        Boolean result = roomDao.joinRoom(1, 1);
        if (result)
            assertTrue(result);
        else assertFalse(result);
    }

    @Test
    public void enterRoomTest2() {
        Boolean result = roomDao.joinRoom(1, 2);
        if (result)
            assertTrue(result);
        else assertFalse(result);

    }

    @Test
    public void enterRoomTest3() {
        Boolean result = roomDao.joinRoom(1, 3);
        if (result)
            assertTrue(result);
        else assertFalse(result);
    }

    @Test
    public void leaveRoomTest1() {
        Boolean result = roomDao.leaveRoom(1, 1);
        if (result)
            assertTrue(result);
        else assertFalse(result);
    }

    @Test
    public void leaveRoomTest2() {
        Boolean result = roomDao.leaveRoom(1, 2);
        if (result)
            assertTrue(result);
        else assertFalse(result);
    }

    @Test
    public void leaveRoomTest3() {
        Boolean result = roomDao.leaveRoom(1, 3);
        if (result)
            assertTrue(result);
        else assertFalse(result);
    }

}

