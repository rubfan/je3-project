package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

import ua.od.game.model.CardEntity;
import ua.od.game.repository.dao.DbTest;

/**
 * @author DemianSH
 **/

public class CardDaoImplTest extends DbTest {

    CardDaoImpl cardDao;

    @Before
    public void init() {
        cardDao = new CardDaoImpl();
    }

    @Test
    public void getAllCardListtest() {
        List<CardEntity> cardsTest = cardDao.getAllCardList();
        Assert.assertFalse(cardsTest.isEmpty());
        Assert.assertEquals("Granary", cardsTest.get(0).getName());
        Assert.assertEquals("Chicken House", cardsTest.get(2).getName());
    }
}