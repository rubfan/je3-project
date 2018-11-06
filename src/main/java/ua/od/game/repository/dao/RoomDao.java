package ua.od.game.repository.dao;

import ua.od.game.model.RoomEntity;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface RoomDao {
    List<RoomEntity> getRoomList();
    Boolean joinRoom(Integer roomId, Integer accountId);
    Boolean leaveRoom(Integer roomId, Integer accountId);
}
