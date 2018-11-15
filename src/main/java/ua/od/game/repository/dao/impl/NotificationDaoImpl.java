package ua.od.game.repository.dao.impl;

import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;

import ua.od.game.model.NotificationEntity;

import java.util.LinkedList;
import java.util.List;


public class NotificationDaoImpl {


    public List<NotificationDaoImpl> getAllNotificationList(Integer userID) {

        String selection = "SELECT  Notification.id, Notification.name, Notification.description, " +
                "Trigger_Notification.building_number, Trigger_Notification.resource_number, Trigger_Notification.upgrade_number, " +
                "Trigger_Notification.building_id, Trigger_Notification.resource_id, Trigger_Notification.upgrade_id " +
                " FROM Trigger_Notification " +
                "  LEFT OUTER JOIN Notification " +
                "  ON Trigger_Notification.id = Notification.id " +
                " LEFT OUTER JOIN Notification AS n2 " +
                " ON Trigger_Notification.building_id = Trigger_Notification.building_number " +
                " LEFT OUTER JOIN Notification AS n3 " +
                " ON Trigger_Notification.resource_id = Trigger_Notification.resource_number " +
                " LEFT OUTER JOIN Notification AS n4 " +
                " ON Trigger_Notification.upgrade_id = Trigger_Notification.upgrade_number;";

        return SqlHelper.prepareStatement(selection, pstmt -> {
          //  pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();
            List<NotificationEntity> list = new LinkedList<>();
            List<NotificationEntity> buildingTriger = new LinkedList<>();
            List<NotificationEntity> resourcetriger = new LinkedList<>();
            List<NotificationEntity> upgradeTriger = new LinkedList<>();
            while (rs.next()) {
                list.add(new NotificationEntity() {{
                    setId(rs.getInt("id"));
                    setName(rs.getString("name"));
                    setDescription(rs.getString("description"));

                }});

                buildingTriger.add(new NotificationEntity() {{
                    setBuildingId(rs.getInt("building_id"));
                    setBuildingNumber(rs.getFloat("building_number"));
                }});

                resourcetriger.add(new NotificationEntity() {{
                    setResourceId(rs.getInt("resource_id"));
                    setResourceNumber(rs.getFloat("resource_number"));

                }});
                upgradeTriger.add(new NotificationEntity() {{
                    setUpgradeId(rs.getInt("upgrade_id"));
                    setUpgradeNumber(rs.getFloat("upgrade_number"));
              }});
           }

            return list;
        });

    }


}
