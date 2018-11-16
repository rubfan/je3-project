package ua.od.game.repository.dao.impl;

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
    private List<String> messages = new LinkedList<>();

    public List<NotificationEntity> getAllNotificationList() {

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
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(new NotificationEntity() {{
                    setId(rs.getInt("id"));
                    setName(rs.getString("name"));
                    setDescription(rs.getString("description"));
                    setBuildingId(rs.getInt("building_id"));
                    setBuildingNumber(rs.getFloat("building_number"));
                    setResourceId(rs.getInt("resource_id"));
                    setResourceNumber(rs.getFloat("resource_number"));
                    setUpgradeId(rs.getInt("upgrade_id"));
                    setUpgradeNumber(rs.getFloat("upgrade_number"));
                }});
            }

            for (int i = 0; i < list.size(); i++) {
                int x = i;
                buildingTrigger.add(new NotificationEntity() {
                    {
                        setBuildingId(list.get(x).getBuildingId());
                        setBuildingNumber(list.get(x).getBuildingNumber());
                    }
                });
                upgradeTrigger.add(new NotificationEntity() {
                    {
                        setUpgradeId(list.get(x).getUpgradeId());
                        setUpgradeNumber(list.get(x).getUpgradeNumber());
                    }
                });

                resourceTrigger.add(new NotificationEntity() {
                    {
                        setResourceId(list.get(x).getResourceId());
                        setResourceNumber(list.get(x).getResourceNumber());
                    }
                });

                messages.add(list.get(i).message());
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

    public List<String> getMessages() {
        getAllNotificationList();
        return messages;
    }

}

