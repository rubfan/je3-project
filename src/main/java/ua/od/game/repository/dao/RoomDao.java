package ua.od.game.repository.dao;

import ua.od.game.model.RoomEntity;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface RoomDao {
    List<RoomEntity> getRoomList();
    void joinRoom(Integer roomId, Integer userId);
    void leaveRoom(Integer roomId, Integer userId);
}
