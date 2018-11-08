package ua.od.game.service;

import ua.od.game.dto.RoomDto;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface RoomService {
    List<RoomDto> getRoomList();
    void joinRoom(Integer roomId, Integer userId);
    void leaveRoom(Integer userId);
}
