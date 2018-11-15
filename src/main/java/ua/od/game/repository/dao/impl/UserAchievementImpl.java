package ua.od.game.repository.dao.impl;

import ua.od.game.model.AchievementNumberEntity;
import ua.od.game.repository.dao.UserAchievementDAO;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class UserAchievementImpl implements UserAchievementDAO {

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

/*
Создать ua.od.game.repository.dao.UserAchievementDAO class
в котором будут методы:

method: List<AchievementNumberEntity> getUserNotifications(Integer userId)
description: метод должен возвращать список обьектов AchievementNumberEntity
в котором будут заполнены из базы 2 поля:
id - айди ачивмента юзера
number - количество ачивментов

Database script:
CREATE TABLE User_Achievement (
id INT NOT NULL AUTO_INCREMENT,
user_id INT NOT NULL,
achievement_id INT NOT NULL,
number FLOAT NOT NULL,
PRIMARY KEY (id)
);


 */
