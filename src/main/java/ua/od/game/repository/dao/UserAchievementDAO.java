package ua.od.game.repository.dao;

import ua.od.game.model.AchievementNumberEntity;

import java.util.List;

public interface UserAchievementDAO {

    List<AchievementNumberEntity> getUserNotifications(Integer userId);


}
