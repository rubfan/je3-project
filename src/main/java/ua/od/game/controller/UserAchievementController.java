package ua.od.game.controller;

import ua.od.game.dto.UserAchievementDto;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface UserAchievementController {
    List<UserAchievementDto> getUserAchievementsList(Integer userId);
}
