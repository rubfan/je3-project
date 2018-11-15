package ua.od.game.repository.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import ua.od.game.repository.dao.DbTest;
//import ua.od.game.repository.dao.impl.NotificationDaoImpl;

import java.util.List;


public class NotificationDaoImplTest extends DbTest {

        NotificationDaoImpl nDAO = new NotificationDaoImpl();

    @Test
    public void getAllNotificationTest() {
       List<NotificationDaoImpl> notificationDaoImplList = nDAO.getAllNotificationList(1);
      System.out.println(nDAO.getAllNotificationList(1) );


        Assert.assertFalse(notificationDaoImplList.isEmpty());
    }

}

