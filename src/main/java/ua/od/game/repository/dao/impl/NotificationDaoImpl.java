package ua.od.game.repository.dao.impl;

import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;

import ua.od.game.model.NotificationEntity;

import java.util.LinkedList;
import java.util.List;


public class NotificationDaoImpl {


<<<<<<< HEAD
    private List<NotificationEntity> list = new LinkedList<>();
    private List<Float> buildingTrigger = new LinkedList<>();
    private List<Float> resourceTrigger = new LinkedList<>();
    private List<Float> upgradeTrigger = new LinkedList<>();


    public List<NotificationEntity> getAllNotificationList(Integer userID) {

        String selection = "SELECT  notification.id, notification.name, notification.description, " +
                "trigger_notification.building_number, trigger_notification.resource_number, trigger_notification.upgrade_number, " +
                "trigger_notification.building_id, trigger_notification.resource_id, trigger_notification.upgrade_id " +
                " FROM trigger_notification " +
                "  LEFT OUTER JOIN notification " +
                "  ON trigger_notification.id = notification.id " +
                " LEFT OUTER JOIN notification AS n2 " +
                " ON trigger_notification.building_id = trigger_notification.building_number " +
                " LEFT OUTER JOIN notification AS n3 " +
                " ON trigger_notification.resource_id = trigger_notification.resource_number " +
                " LEFT OUTER JOIN notification AS n4 " +
                " ON trigger_notification.upgrade_id = trigger_notification.upgrade_number;";


        return SqlHelper.prepareStatement(selection, pstmt -> {
            // pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();


=======
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
>>>>>>> 0669dec5e6c84c87b313dfc09f20b4b233761ae5
            while (rs.next()) {
                list.add(new NotificationEntity() {{
                    setId(rs.getInt("id"));
                    setName(rs.getString("name"));
                    setDescription(rs.getString("description"));
<<<<<<< HEAD
                    setBuildingId(rs.getInt("building_id"));
                    setBuildingNumber(rs.getFloat("building_number"));
                    setResourceId(rs.getInt("resource_id"));
                    setResourceNumber(rs.getFloat("resource_number"));
                    setUpgradeId(rs.getInt("upgrade_id"));
                    setUpgradeNumber(rs.getFloat("upgrade_number"));
                }});
            }
            for (int i = 0; i < list.size(); i++) {
                buildingTrigger.add(i, list.get(i).getBuildingNumber());
                upgradeTrigger.add(list.get(i).getUpgradeNumber());
                resourceTrigger.add(list.get(i).getResourceNumber());
            }


=======

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
>>>>>>> 0669dec5e6c84c87b313dfc09f20b4b233761ae5

            return list;
        });

    }

<<<<<<< HEAD
    public List<Float> getBuildingTrigger() {

        return buildingTrigger;
    }

    public List<Float> getResourceTrigger() {

        return resourceTrigger;
    }

    public List<Float> getUpgradeTrigger() {

        return upgradeTrigger;
    }

}

=======

}
>>>>>>> 0669dec5e6c84c87b313dfc09f20b4b233761ae5
