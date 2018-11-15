package ua.od.game.repository.dao;

import java.util.List;
import ua.od.game.model.NotificationEntity;

public interface NotificationDao {
    List<NotificationEntity> getAllNotificationList();
}
