package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.UpgradeProductEntity;
import ua.od.game.repository.dao.DbTest;
import ua.od.game.repository.dao.UpgradeProductDao;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class RoomDaoImplTest extends DbTest {
    UpgradeProductDao upgradeProductDao;

    @Before
    public void init() {
        upgradeProductDao = new UpgradeProductDaoImpl();
    }

    @Test
    public void getRoomListTest() {
        List<UpgradeProductEntity> upgradeProduct = upgradeProductDao.getUpgradeProductList();
        for (int i = 0; i < upgradeProduct.size(); i++) {
            System.out.print(upgradeProduct.get(i).getId() + " ");

        }
        if (!upgradeProduct.isEmpty())
            assertTrue(true);
    }
}

