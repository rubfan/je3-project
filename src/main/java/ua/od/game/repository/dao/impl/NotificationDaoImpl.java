package ua.od.game.repository.dao.impl;

import ua.od.game.model.BuildingEntity;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;

import ua.od.game.model.NotificationEntity;

import java.util.LinkedList;
import java.util.List;


public class NotificationDaoImpl {

    private List<NotificationEntity> list = new LinkedList<>();
    private List<NotificationEntity> buildingTrigger = new LinkedList<>();
    private List<NotificationEntity> resourceTrigger = new LinkedList<>();
    private List<NotificationEntity> upgradeTrigger = new LinkedList<>();


    public List<NotificationEntity> getAllNotificationList() {

        String message = "SELECT notification.id, notification.name, notification.description, trigger_notification.notification_id, " +
                "trigger_notification.building_number, trigger_notification.resource_number, trigger_notification.upgrade_number, " +
                "trigger_notification.building_id, trigger_notification.resource_id, trigger_notification.upgrade_id " +
                "FROM trigger_notification " +
                " LEFT JOIN notification " +
                "ON trigger_notification.notification_id = notification.id " +
                "LEFT JOIN notification AS n2 " +
                "ON trigger_notification.building_id = trigger_notification.building_number " +
                "LEFT JOIN notification AS n3 " +
                "ON trigger_notification.resource_id = trigger_notification.resource_number " +
                "LEFT JOIN notification AS n4 " +
                "ON trigger_notification.upgrade_id = trigger_notification.upgrade_number; ";


        return SqlHelper.prepareStatement(message, pstmt -> {
            ResultSet rs = pstmt.executeQuery();
            int x = 1;
            while (rs.next()) {

                if (rs.getInt("id") != x - 1) {
                    list.add(new NotificationEntity() {{
                        setId(rs.getInt("id"));
                        setName(rs.getString("name"));
                        setDescription(rs.getString("description"));
                    }});
                    x++;
                }


                buildingTrigger.add(new NotificationEntity() {{
                    setNotificationId(rs.getInt("notification.id"));
                    setBuildingId(rs.getInt("building_id"));
                    setBuildingNumber(rs.getFloat("building_number"));

                }});

                resourceTrigger.add(new NotificationEntity() {{
                    setNotificationId(rs.getInt("notification.id"));
                    setResourceId(rs.getInt("resource_id"));
                    setResourceNumber(rs.getFloat("resource_number"));
                }});
                upgradeTrigger.add(new NotificationEntity() {{
                    setNotificationId(rs.getInt("notification.id"));
                    setUpgradeId(rs.getInt("upgrade_id"));
                    setUpgradeNumber(rs.getFloat("upgrade_number"));

                }});
            }

//for (int i = 0; i< buildingTrigger.size(); i++){
//    int notifId = buildingTrigger.get(i).getNotificationId();
//    int buildId = buildingTrigger.get(i).getBuildingId();
//    Float buildNum = buildingTrigger.get(i).getBuildingNumber();
//    list.set(notifId,buildingTrigger.set)
//    setExectBuildingTrigger(buildingTrigger.get(i).getNotificationId()-1);
//    System.out.println(buildingTrigger.get(i).getNotificationId() + " --");
}
 return list;
        });


    }



    public List<NotificationEntity> getBuildingTrigger() {

        getAllNotificationList();
        return buildingTrigger;
    }

    public List<NotificationEntity> getResourceTrigger() {

        getAllNotificationList();
        return resourceTrigger;
    }

    public List<NotificationEntity> getUpgradeTrigger() {

        getAllNotificationList();
        return upgradeTrigger;
    }


}

