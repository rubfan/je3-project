package ua.od.game.repository.dao.impl;

import ua.od.game.repository.dao.UserNotificationDao;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class UserNotificationDaoImpl implements UserNotificationDao {
    @Override
    public List<Integer> getUserNotifications(Integer userId) {
        return SqlHelper.prepareStatement("select  a.notification_id from (select a.notification_id " +
                "from Trigger_Notification a " +
                "inner join User_Resource b " +
                "on a.resource_id = b.resource_id and b.user_id = ? and a.resource_number <= b.number " +
                "inner join User_Upgrade c " +
                "on a.upgrade_id = c.upgrade_id and c.user_id = ? and a.upgrade_number <= c.number " +
                "inner join User_Building d " +
                "on a.building_id = d.building_id and c.user_id = ? and a.building_number <= d.number) as a, " +
                "User_Notification e where a.notification_id = e.notification_id and e.user_id = ? and " +
                "e.is_shown <> true", pstmt -> {
            pstmt.setInt(1,userId);
            ResultSet rs = pstmt.executeQuery();
            List<Integer> list = new LinkedList<>();
            while(rs.next()) {
                list.add(rs.getInt("notification_id"));
            }
            return list;
        });
    }

    @Override
    public boolean clearUserNotifications(Integer userId) {
        return SqlHelper.prepareStatement("DELETE FROM User_Notification where user_id = ?", pstmt -> {
            pstmt.setInt(1,userId);
            pstmt.executeUpdate();
            return true;
        });
    }
}
