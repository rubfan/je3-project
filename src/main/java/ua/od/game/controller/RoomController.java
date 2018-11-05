package ua.od.game.controller;

import ua.od.game.dto.AccountRoomDto;
import ua.od.game.dto.RoomDto;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface RoomController {
    List<RoomDto> getAllRoomList();
    List<AccountRoomDto> getAccountRoomList();
    Response joinRoom(Integer roomId, Integer accountId);
    Response leaveRoom(Integer roomId, Integer accountId);
}
