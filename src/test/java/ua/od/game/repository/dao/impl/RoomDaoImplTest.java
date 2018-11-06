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
            System.out.print(rooms.get(i).getAccount1Name()+ " ");
            System.out.println(rooms.get(i).getAccount2Name()+ " ");
        }
    }
    @Test
    public void enterRoomTest1() {
        System.out.println(roomDao.joinRoom(443, 7).toString());
    }

    @Test
    public void enterRoomTest2() {
        System.out.println(roomDao.joinRoom(443, 8).toString());
    }

    @Test
    public void enterRoomTest3() {
        System.out.println(roomDao.joinRoom(443, 9).toString());
    }

    @Test
    public void leaveRoomTest1() {
        System.out.println(roomDao.leaveRoom(443, 7).toString());
    }

    @Test
    public void leaveRoomTest2() {
        System.out.println(roomDao.leaveRoom(443, 8).toString());
    }

    @Test
    public void leaveRoomTest3() {
        System.out.println(roomDao.leaveRoom(443, 9).toString());
    }

    @Test
    public void  test() {
        String URL = "jdbc:mysql://localhost/je3_web_game";
        String USER = "root";
        String PASS = "qwerty";
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(conn.createStatement().executeUpdate("UPDATE room SET account_1_id = CASE WHEN account_1_id IS NULL THEN 9 ELSE account_1_id END, account_2_id = CASE WHEN account_1_id IS NOT NULL AND account_2_id IS NULL AND account_1_id <> 9  THEN 9 ELSE account_2_id END WHERE id = 443"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
