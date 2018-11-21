package ua.od.game.controller.impl;

import ua.od.game.controller.NotificationController;
import ua.od.game.dto.NotificationDto;
import ua.od.game.service.NotificationService;

import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.LinkedList;
import java.util.List;

@Path("/notification")
public class NotificationControllerImpl implements NotificationController {

    @Inject
    public NotificationService notificationService;

    public List<NotificationDto> getAllNotificationList(){

        return getAllNotificationList();
    }

    List<NotificationController> NotificationList = new LinkedList<>();



}
