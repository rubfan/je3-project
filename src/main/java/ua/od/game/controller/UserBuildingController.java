package ua.od.game.controller;

import ua.od.game.dto.UserBuildingDto;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface UserBuildingController {
    List<UserBuildingDto> getUserBuildingList(Integer userId);
    Response clearUserBuildingList(Integer userId);
}
