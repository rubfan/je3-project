package ua.od.game.service;

import ua.od.game.dto.UserDto;

/**
 * @author ruslan.gramatic
 */
public interface UserService {
    String loginUser(UserDto user);
    void logoutUser(String token);
    String createNewUser(UserDto user);
    UserDto getUserByToken(String token);
    UserDto getUserById(Integer userId);
}
