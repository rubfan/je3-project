package ua.od.game.repository.dao.impl;

import ua.od.game.model.AchievementNumberEntity;
import ua.od.game.repository.dao.UserAchievementDAO;

import java.util.List;

public class UserAchievementImpl implements UserAchievementDAO {

    public List<AchievementNumberEntity> getUserNotifications(Integer userId) {
        return null;
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
