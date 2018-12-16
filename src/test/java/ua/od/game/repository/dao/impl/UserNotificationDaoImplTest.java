package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import ua.od.game.repository.dao.DbTest;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class UserNotificationDaoImplTest extends DbTest {

    UserNotificationDaoImpl userNotification;

    @Before
    public void init() {
        userNotification = new UserNotificationDaoImpl();
    }

    @Test
    public void testGetUserNotifications() {
        int count;
        int view;
        int unview;
        count = SqlHelper.prepareStatement("select count(*) from Trigger_Notification", pstmt -> {
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? rs.getInt("count(*)"): 0;
        });
        view = SqlHelper.prepareStatement("select count(*) from User_Notification where is_shown = true and user_id = 1", pstmt -> {
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? rs.getInt("count(*)"): 0;
        });
        unview = count - view;
        assertFalse(unview < 0);
    }

    @Test
    public void testClearUserNotifications() {
        assertTrue(userNotification.clearUserNotifications(1));
    }
}
