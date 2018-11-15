package ua.od.game.repository.dao;

import java.util.List;

public interface UserNotificationDao {
    List<Integer> getUserNotifications(Integer userId);
    boolean clearUserNotifications(Integer userId);
}
