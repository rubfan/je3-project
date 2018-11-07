package ua.od.game.controller;

import ua.od.game.dto.UserUpgradeDto;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface UserUpgradeController {
    List<UserUpgradeDto> getUserUpgradeList(Integer userId);
}
