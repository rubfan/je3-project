package ua.od.game.repository.dao.impl;

import ua.od.game.model.AchievementNumberEntity;
import ua.od.game.repository.dao.UserAchievementDAO;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class UserAchievementImpl implements UserAchievementDAO {

    @Override
    public List<AchievementNumberEntity> getUserNotifications(Integer userId) {
        return SqlHelper.prepareStatement("Select * from `User_Achievement` where user_id = ?", prpstmt -> {
            prpstmt.setInt(1, userId);
            ResultSet resultSet = prpstmt.executeQuery();
            List<AchievementNumberEntity> list = new LinkedList<>();
            while (resultSet.next()) {
                list.add(new AchievementNumberEntity() {{
                    setAchievement_id(resultSet.getInt("achievement_id"));
                    setNumber(resultSet.getFloat("number"));
                }});
            }
            return list;
        });
    }
}

