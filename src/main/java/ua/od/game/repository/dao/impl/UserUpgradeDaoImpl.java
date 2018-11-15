package ua.od.game.repository.dao.impl;

import ua.od.game.model.UpgradeNumberEntity;
import ua.od.game.repository.dao.UserUpgradeDao;
import ua.od.game.repository.helper.SqlHelper;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class UserUpgradeDaoImpl implements UserUpgradeDao {

    @Override
    public List<UpgradeNumberEntity> getUserUpgrades(Integer userId) {
        return SqlHelper.prepareStatement("SELECT * FROM User_Upgrade where user_id = ?", pstmt -> {
            pstmt.setInt(1,userId);
            ResultSet rs = pstmt.executeQuery();
            List<UpgradeNumberEntity> list = new LinkedList<>();
            while(rs.next()) {
                list.add(new UpgradeNumberEntity(){{
                    setUpgradeId(rs.getInt("upgrade_id"));
                    setNumber(rs.getFloat("number"));
                }});
            }
            return list;
        });
    }

    @Override
    public boolean clearUserUpgrades(Integer userId) {
        return SqlHelper.prepareStatement("DELETE FROM User_Upgrade where user_id = ?", pstmt -> {
            pstmt.setInt(1,userId);
            pstmt.executeUpdate();
            return true;
        });
    }

    @Override
    public boolean prepareDefaultUserUpgrades(Integer userId) {
        return  SqlHelper.prepareStatement("INSERT INTO User_Upgrade(user_id,upgrade_id,number) " +
                "SELECT ? , id, default_number FROM  Upgrade WHERE default_number <> 0", pstmt -> {
            pstmt.setInt(1,userId);
            pstmt.executeUpdate();
            return true;
        });
    }
}
