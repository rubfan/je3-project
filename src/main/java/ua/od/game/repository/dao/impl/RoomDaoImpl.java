package ua.od.game.repository.dao.impl;

import ua.od.game.model.RoomEntity;
import ua.od.game.repository.dao.RoomDao;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by ruslan.gramatic
 */
public class RoomDaoImpl implements RoomDao {

    private final String JOIN_ROOM_QUERY_ROOM_QUERY = new StringBuilder()
            .append("UPDATE room ")
            .append("SET user_1_id = CASE WHEN user_1_id IS NULL ")
                                 .append("THEN ? ")
                                 .append("ELSE user_1_id END, ")
                .append("user_2_id = CASE WHEN user_1_id IS NOT NULL AND user_2_id IS NULL AND user_1_id <> ? ")
                                 .append("THEN ? ")
                                 .append("ELSE user_2_id END ")
            .append("WHERE id = ?")
            .toString();

    private final String JOIN_ROOM_QUERY_ACCOUNT_QUERY = "UPDATE account SET room_id = ? WHERE id = ?";

    private final String LEAVE_ROOM_QUERY_ROOM_QUERY = new StringBuilder()
            .append("UPDATE room ")
            .append("SET user_1_id = CASE WHEN user_1_id = ? ")
                                 .append("THEN NULL ")
                                 .append("ELSE user_1_id END, ")
                .append("user_2_id = CASE WHEN user_2_id = ? ")
                                 .append("THEN NULL ")
                                 .append("ELSE user_2_id END ")
            .append("WHERE user_1_id = ? OR user_2_id = ?")
            .toString();

    private final String GET_ROOM_LIST_QUERY = "SELECT * FROM room";
    private final String CHECK_ROOM_IS_FULL_QUERY = "select user_1_id, user_2_id from room where id = ?";
    //TODO
    //private final String GET_USER_NAME_BY_ACCOUNT_ID = "select user.name from account join user on account.user_id = user.id where account.id = ?";

    public List<RoomEntity> getRoomList() {
        return SqlHelper.prepareStatement(GET_ROOM_LIST_QUERY, statementForRoomList -> {
            ResultSet roomsResultSet = statementForRoomList.executeQuery();
            List<RoomEntity> rooms = new LinkedList<RoomEntity>();
            while (roomsResultSet.next()) {
                rooms.add(new RoomEntity() {{
                    setId(roomsResultSet.getInt("id"));
                    setName(roomsResultSet.getString("name"));
                    setDescription(roomsResultSet.getString("description"));
                    //TODO Create Methods to get Name by id in UserDao and inject them here
                    setAccount1Name(roomsResultSet.getString("user_1_id"));
                    setAccount2Name(roomsResultSet.getString("user_1_id"));
                    //TODO end
                }});
            }
            return rooms;
        });
    }

    public Boolean joinRoom(Integer roomId, Integer userId) {
       return SqlHelper.prepareStatement(CHECK_ROOM_IS_FULL_QUERY, statementForRoomCheck -> {
           statementForRoomCheck.setInt(1, roomId);
           ResultSet resultSetCheck = statementForRoomCheck.executeQuery();
           resultSetCheck.next();
           if (resultSetCheck.getInt("user_1_id") > 0 && resultSetCheck.getInt("user_2_id") > 0)
               return false;
           else return SqlHelper.prepareStatement(JOIN_ROOM_QUERY_ROOM_QUERY, statementForRoom -> {
                statementForRoom.setInt(1, userId);
                statementForRoom.setInt(2, userId);
                statementForRoom.setInt(3, userId);
                statementForRoom.setInt(4, roomId);
                statementForRoom.executeUpdate();
                return true;
                });
            });
    }

    public Boolean leaveRoom(Integer roomId, Integer userId) {
       return SqlHelper.prepareStatement(LEAVE_ROOM_QUERY_ROOM_QUERY, statementForRoom -> {
            statementForRoom.setInt(1, userId);
            statementForRoom.setInt(2, userId);
            statementForRoom.setInt(3, userId);
            statementForRoom.setInt(4, userId);
            return statementForRoom.executeUpdate() > 0 ? true : false;
       });
    }
}
