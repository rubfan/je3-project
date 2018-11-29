package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import ua.od.game.model.MessageEntity;
import ua.od.game.repository.dao.DbTest;
import ua.od.game.repository.dao.MessageDao;

import java.util.List;

/**
 * @author AndreiDatc & DemianSH
 */

public class MessageDaoTest extends DbTest {

    MessageDao messDaoTest;


    @Before
    public void init() {
        messDaoTest = new MessageDaoImpl();
    }


   @Test
    public void getMessageTest() {
        List<MessageEntity> messTest;
        messTest = messDaoTest.getMessages(1, 2);
        Assert.assertEquals("hello", messTest.get(0).getText());
        Assert.assertEquals("how are u?", messTest.get(1).getText());

        messTest.forEach((MessageEntity) -> {
            System.out.println("text: " + MessageEntity.getText() + " to: " + MessageEntity.getToUserId() +
                    " from: " + MessageEntity.getFromUserId() + " time: " + MessageEntity.getTime() + " id: " +
                    MessageEntity.getId());
        });
    }

    @Test
    public void sendMessageTest() {
        messDaoTest.sendMessage(1,2,"glhf");
        List<MessageEntity> messTest1;
        messTest1 = messDaoTest.getMessages(1,2);
        Assert.assertEquals("glhf", messTest1.get(2).getText());

        messTest1.forEach((MessageEntity) -> {
            System.out.println("id: " + MessageEntity.getId() + " text: " + MessageEntity.getText() +
                    " time: " + MessageEntity.getTime());
        });
    }
}
