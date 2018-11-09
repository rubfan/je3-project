package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.UpgradeProductEntity;
import ua.od.game.repository.dao.DbTest;
import ua.od.game.repository.dao.UpgradeProductDao;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class UpgradeProductDaoImplTest extends DbTest {
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
            System.out.print(upgradeProduct.get(i).getUpgradeId() + " ");
            System.out.print(upgradeProduct.get(i).getUpgradeName() + " ");
            System.out.print(upgradeProduct.get(i).getUpgradeDescription() + " ");
            System.out.print(upgradeProduct.get(i).getBuildingId() + " ");
            System.out.print(upgradeProduct.get(i).getBuildingName() + " ");
            System.out.print(upgradeProduct.get(i).getBuildingDescription() + " ");
            System.out.print(upgradeProduct.get(i).getBuildingProductId() + " ");
            System.out.print(upgradeProduct.get(i).getResourceName() + " ");
            System.out.print(upgradeProduct.get(i).getResourceDescription() + " ");
            System.out.print(upgradeProduct.get(i).getResourceNumberPerSecond() + " ");
        }
        if (!upgradeProduct.isEmpty())
            assertTrue(true);
    }
}