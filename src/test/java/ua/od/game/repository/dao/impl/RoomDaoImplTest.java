package ua.od.game.repository.dao.impl;


import org.junit.Before;
import org.junit.Test;

import ua.od.game.model.RoomEntity;
import ua.od.game.repository.dao.DbTest;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Mazovskiy Mihail
 */

public class RoomDaoImplTest extends DbTest {
    RoomDaoImpl roomDao;

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
        if (!rooms.isEmpty())
        assertTrue(true);
    }

    @Test
    public void joinToUnExistedRoomTest() {
        Boolean result = roomDao.joinRoom(23534, 1);
        System.out.println(result);
        assertFalse(result);
    }

    @Test
    public void unExistedUserJoinRoomTest() {
        Boolean result = roomDao.joinRoom(1, 234435435);
        System.out.println(result);
        assertFalse(result);
    }

    @Test
    public void joinFreeRoomTest() {
        roomDao.kickUsersFromRoom(1);
        Boolean result = roomDao.joinRoom(1, 3);
        System.out.println(result);
        assertTrue(result);
    }

    @Test
    public void joinRoomWithOnePlayerInTest() {
        roomDao.kickUsersFromRoom(1);
        roomDao.joinRoom(1,1);
        Boolean result = roomDao.joinRoom(1, 3);
        System.out.println(result);
        assertTrue(result);
    }

    @Test
    public void joinFullRoomTest() {
        roomDao.kickUsersFromRoom(1);
        roomDao.joinRoom(1,1);
        roomDao.joinRoom(1,2);
        Boolean result = roomDao.joinRoom(1, 3);
        System.out.println(result);
        assertFalse(result);
    }

    @Test
    public void userInRoomLeaveRoomTest() {
        roomDao.joinRoom(10,4);
        Boolean result = roomDao.leaveRoom(4);
        System.out.println(result);
        assertTrue(result);
    }

    @Test
    public void userNotInRoomLeaveRoomTest() {
        Boolean result = roomDao.leaveRoom(4);
        System.out.println(result);
        assertFalse(false);
    }

    @Test
    public void unExistedUserLeaveRoomTest() {
        Boolean result = roomDao.leaveRoom(435345345);
        System.out.println(result);
        assertFalse(result);
    }
}

