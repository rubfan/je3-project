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
        List<NotificationEntity> notificationDaoImplList = nDAO.getAllNotificationList(1);

        for (int i = 0; i < notificationDaoImplList.size(); i++) {
            System.out.print("id = " + notificationDaoImplList.get(i).getId() + "; user = " + notificationDaoImplList.get(i).getName()
                    + "; Description = " + notificationDaoImplList.get(i).getDescription() + "; Building Number = " + notificationDaoImplList.get(i).getBuildingNumber() +
                    "; Resource Number = " + notificationDaoImplList.get(i).getResourceNumber() + "; Upgrade Number = " + notificationDaoImplList.get(i).getUpgradeNumber());

        }
        Assert.assertFalse(notificationDaoImplList.isEmpty());
    }

    @Test
    public void getBuildingTriggerTest() {
        List<Float> buildingList = nDAO.getBuildingTrigger();
        nDAO.getAllNotificationList(2);
        for (int i = 0; i < buildingList.size(); i++) {
            int x = i + 1;
            System.out.println("id = " + x + "; Building Number = " + buildingList.get(i) + ";");
        }
        Assert.assertFalse(buildingList.isEmpty());
    }

    @Test
    public void getAResourceTriggerTest() {
        List<Float> resourceList = nDAO.getResourceTrigger();
        nDAO.getAllNotificationList(2);
        for (int i = 0; i < resourceList.size(); i++) {
            int x = i + 1;
            System.out.println("id = " + x + "; Resource Number = " + resourceList.get(i) + ";");
        }
        Assert.assertFalse(resourceList.isEmpty());
    }

    @Test
    public void getUpgradesTriggerTest() {
        List<Float> upgradesList = nDAO.getUpgradeTrigger();
        nDAO.getAllNotificationList(1);
        for (int i = 0; i < upgradesList.size(); i++) {
            int x = i + 1;
            System.out.println("id = " + x + "; Upgrade Number = " + upgradesList.get(i) + ";");
        }
        Assert.assertFalse(upgradesList.isEmpty());

    }
}
