package ua.od.game.repository.dao.impl;

import ua.od.game.model.RoomEntity;
import ua.od.game.repository.dao.RoomDao;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by ruslan.gramatic
 */
public class RoomDaoImpl implements RoomDao {

    public List<RoomEntity> getRoomList() {
        return SqlHelper.createStatement(statement -> {
            ResultSet rs = statement.executeQuery("select r.id, r.name, r.description from Room r");
            List<RoomEntity> rooms = new LinkedList<>();
            while (rs.next()) {
                rooms.add(new RoomEntity() {{
                    setId(rs.getInt("id"));
                    setName(rs.getString("name"));
                    setDescription(rs.getString("description"));
                }});
            }
            return rooms;
        });
    }

    public void joinRoom(Integer roomId, Integer accountId) {

    }

    public void leaveRoom(Integer roomId, Integer accountId) {

    }
}
