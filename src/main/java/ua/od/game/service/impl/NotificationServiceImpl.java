package ua.od.game.service.impl;

import ua.od.game.dto.NotificationDto;
import ua.od.game.repository.dao.NotificationDao;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class NotificationServiceImpl {

    @Inject
    public NotificationDao notificationDao;

//
//    public List<NotificationDto> getNotificationList() {
//
//        final List<NotificationDto> notificationList = new LinkedList<>();
//
//        notificationDao.getAllNotificationList().forEach(NotificationEntity -> notificationList.add(new NotificationDto() {{
//            setId(NotificationEntity.getId());
//            setName(NotificationEntity.getName());
//            setDescription(NotificationEntity.getDescription());
//            setBuildingId(NotificationEntity.getBuildingId());
//            setBuildingNumber(NotificationEntity.getBuildingNumber());
//            setResourceId(NotificationEntity.getResourceId());
//            setResourceNumber(NotificationEntity.getResourceNumber());
//            setUpgradeId(NotificationEntity.getUpgradeId());
//            setUpgradeNumber(NotificationEntity.getUpgradeNumber());
//        }}));
//
//        return notificationList;
//    }
}
