package ua.od.game.repository.dao.impl;

import org.junit.Before;
import org.junit.Test;
import ua.od.game.model.UpgradeNumberEntity;
import ua.od.game.repository.dao.DbTest;
import ua.od.game.repository.helper.SqlHelper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class UserUpgradeDaoImplTest extends DbTest {

    UserUpgradeDaoImpl userUpgradeDao;
    List<UpgradeNumberEntity> list;

    @Before
    public void init() {
        userUpgradeDao = new UserUpgradeDaoImpl();
        list = new LinkedList<>();
    }

    @Test
    public void testPrepareDefaultUserUpgrades() {
        assertTrue(userUpgradeDao.prepareDefaultUserUpgrades(1));
    }

    @Test
    public void testGetUserUpgrades() {
        int count;
        count = SqlHelper.prepareStatement("SELECT count(*) FROM  Upgrade WHERE default_number <> 0", pstmt -> {
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? rs.getInt("count(*)") : 0;
        });
        list = userUpgradeDao.getUserUpgrades(1);
        assertEquals(count,list.size());
    }

    @Test
    public void testClearUserUpgrades() {
        assertTrue(userUpgradeDao.clearUserUpgrades(1));
    }
}
