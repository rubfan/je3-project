package ua.od.game.repository.dao;

import ua.od.game.model.RoomEntity;
import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface RoomDao {
    List<RoomEntity> getRoomList();
    Boolean joinRoom(Integer roomId, Integer userId);
    Boolean leaveRoom(Integer userId);

}
