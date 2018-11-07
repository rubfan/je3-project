package ua.od.game.controller;

import ua.od.game.dto.UserRoomDto;
import ua.od.game.dto.RoomDto;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface RoomController {
    List<RoomDto> getAllRoomList();
    List<UserRoomDto> getUserRoomList();
    Response joinRoom(Integer roomId, Integer userId);
    Response leaveRoom(Integer roomId, Integer userId);
}
