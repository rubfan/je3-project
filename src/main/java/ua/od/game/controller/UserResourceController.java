package ua.od.game.controller;

import ua.od.game.dto.UserResourceDto;


import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface UserResourceController {
    Response clearUserResourceList(Integer userId);
    List<UserResourceDto> getUserResourceList(Integer userId);
}
