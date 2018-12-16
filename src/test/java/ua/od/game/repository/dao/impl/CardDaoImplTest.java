package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

import ua.od.game.model.card.CardEntity;
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
        Assert.assertFalse(cardsTest.get(37).getProduct().getP1Resources().isEmpty());
        Assert.assertTrue(cardsTest.get(50).getProduct().getP1Resources().size() > 0);

        cardsTest.forEach((CardEntity) -> {
            System.out.println("id: " + CardEntity.getCardId() + " name: " + CardEntity.getName() + " group: " +
                    CardEntity.getGroup().getName() + " bl: " + CardEntity.getProduct().getP1Buildings().size() +
                    " rs: " + CardEntity.getProduct().getP1Resources().size() + " up: " +
                    CardEntity.getProduct().getP1Upgrades().size());
        });
    }
}