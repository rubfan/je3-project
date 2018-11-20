package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

import ua.od.game.model.cardEntity.CardEntity;
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
    }
}