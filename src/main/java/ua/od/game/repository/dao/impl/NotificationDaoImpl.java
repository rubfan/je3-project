package ua.od.game.repository.dao.impl;

import ua.od.game.model.TriggersEntity.BuildingTriggerEntity;
import ua.od.game.model.TriggersEntity.ResourceTriggerEntity;
import ua.od.game.model.TriggersEntity.UpgradeTriggerEntity;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;

import ua.od.game.model.NotificationEntity;

import java.util.LinkedList;
import java.util.List;


public class NotificationDaoImpl {

    private List<NotificationEntity> list = new LinkedList<>();
    private List<BuildingTriggerEntity> buildingTrigger = new LinkedList<>();
    private List<ResourceTriggerEntity> resourceTrigger = new LinkedList<>();
    private List<UpgradeTriggerEntity> upgradeTrigger = new LinkedList<>();


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


                buildingTrigger.add(new BuildingTriggerEntity() {{
                    setNotificationId(rs.getInt("notification.id"));
                    setBuildingId(rs.getInt("building_id"));
                    setBuildingNumber(rs.getFloat("building_number"));

                }});

                resourceTrigger.add(new ResourceTriggerEntity() {{
                    setNotificationId(rs.getInt("notification.id"));
                    setResourceId(rs.getInt("resource_id"));
                    setResourceNumber(rs.getFloat("resource_number"));
                }});
                upgradeTrigger.add(new UpgradeTriggerEntity() {{
                    setNotificationId(rs.getInt("notification.id"));
                    setUpgradeId(rs.getInt("upgrade_id"));
                    setUpgradeNumber(rs.getFloat("upgrade_number"));

                }});


            }
            return list;
        });


    }



    public List<BuildingTriggerEntity> getBuildingTrigger() {

        getAllNotificationList();
        return buildingTrigger;
    }

    public List<ResourceTriggerEntity> getResourceTrigger() {

        getAllNotificationList();
        return resourceTrigger;
    }

    public List<UpgradeTriggerEntity> getUpgradeTrigger() {

        getAllNotificationList();
        return upgradeTrigger;
    }


}

