package ua.od.game.repository.dao.impl;


import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.RoomEntity;
import ua.od.game.repository.dao.DbTest;
import ua.od.game.repository.dao.RoomDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        for (int i = 0; i < rooms.size(); i++) {
            System.out.print(rooms.get(i).getId() + " ");
            System.out.print(rooms.get(i).getName() + " ");
            System.out.print(rooms.get(i).getDescription()+ " ");
            System.out.print(rooms.get(i).getUser1Name()+ " ");
            System.out.println(rooms.get(i).getUser2Name()+ " ");
        }
    }
    @Test
    public void enterRoomTest1() {
        System.out.println(roomDao.joinRoom(1, 1).toString());
    }

    @Test
    public void enterRoomTest2() {
        System.out.println(roomDao.joinRoom(1, 2).toString());
    }

    @Test
    public void enterRoomTest3() {
        System.out.println(roomDao.joinRoom(1, 3).toString());
    }

    @Test
    public void leaveRoomTest1() {
        System.out.println(roomDao.leaveRoom(1, 1).toString());
    }

    @Test
    public void leaveRoomTest2() {
        System.out.println(roomDao.leaveRoom(1, 2).toString());
    }

    @Test
    public void leaveRoomTest3() {
        System.out.println(roomDao.leaveRoom(1, 3).toString());
    }

}
