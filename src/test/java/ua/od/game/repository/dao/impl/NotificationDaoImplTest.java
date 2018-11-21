package ua.od.game.repository.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ua.od.game.model.NotificationEntity;
import ua.od.game.repository.dao.DbTest;

import java.util.List;


public class NotificationDaoImplTest extends DbTest {
    NotificationDaoImpl nDAO;

    @Before
    public void init() {
        nDAO = new NotificationDaoImpl();
    }

    @Test
    public void getAllNotificationTest() {
        List<NotificationEntity> notificationDaoImplList = nDAO.getAllNotificationList();
        System.out.println(notificationDaoImplList.size());
        for (int i = 0; i < notificationDaoImplList.size(); i++) {
            System.out.println("id = " + notificationDaoImplList.get(i).getId() + "; user = " + notificationDaoImplList.get(i).getName()
                    + "; Description = " + notificationDaoImplList.get(i).getDescription());

        }
        Assert.assertFalse(notificationDaoImplList.isEmpty());
    }

    @Test
    public void getBuildingTriggerTest() {
        List<NotificationEntity> buildingList = nDAO.getBuildingTrigger();
        for (int i = 0; i < buildingList.size(); i++) {

            System.out.println("id = " + buildingList.get(i).getBuildingId() + "; Building Number = " + buildingList.get(i).getBuildingNumber() + ";");
        }
        Assert.assertFalse(buildingList.isEmpty());
    }

    @Test
    public void getAResourceTriggerTest() {
        List<NotificationEntity> resourceList = nDAO.getResourceTrigger();
        for (int i = 0; i < resourceList.size(); i++) {

            System.out.println("id = " + resourceList.get(i).getResourceId() + "; Resource Number = " + resourceList.get(i).getResourceNumber() + ";");
        }
        Assert.assertFalse(resourceList.isEmpty());
    }

    @Test
    public void getUpgradesTriggerTest() {
        List<NotificationEntity> upgradesList = nDAO.getUpgradeTrigger();
        for (int i = 0; i < upgradesList.size(); i++) {

            System.out.println("id = " + upgradesList.get(i).getUpgradeId() + "; Upgrade Number = " + upgradesList.get(i).getUpgradeNumber() + ";");
        }
        Assert.assertFalse(upgradesList.isEmpty());
    }

    @Test
    public void getMessages() {
        List<NotificationEntity> messagesList = nDAO.getAllNotificationList();
        for (int i = 0; i < messagesList.size(); i++) {
            System.out.println(" Message " + messagesList.get(i).message() + " ;");
        }
        Assert.assertFalse(messagesList.isEmpty());
    }


}
