package ua.od.game.repository.dao.impl;

import ua.od.game.model.MessageEntity;
import ua.od.game.repository.dao.MessageDao;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AndreyDatc & DemianSH
 */

public class MessageDaoImpl implements MessageDao {

    private static final String QUERY_GET_MESSAGES = "SELECT id, text, from_user_id, to_user_id, time " +
            " FROM Message " +
            " WHERE from_user_id = ? AND to_user_id = ?;";

    private static final String QUERY_SET_MESSAGE = "INSERT INTO Message(text, from_user_id, to_user_id, time) " +
            " VALUES (?,?,?, NOW());";

    @Override
    public List<MessageEntity> getMessages(Integer userId, Integer enemyId) {
        return SqlHelper.prepareStatement(QUERY_GET_MESSAGES, pstmt -> {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, enemyId);
            ResultSet result = pstmt.executeQuery();
            List<MessageEntity> messageList = new ArrayList<>();
            setMessages(result,messageList);
            return messageList;
        });
    }

    private void setMessages (ResultSet result, List<MessageEntity> messList) throws SQLException {
        while (result.next()) {
            messList.add(new MessageEntity() {{
                setId(result.getInt("id"));
                setText(result.getString("text"));
                setFromUserId(result.getInt("from_user_id"));
                setToUserId(result.getInt("to_user_id"));
                setTime(result.getDate("time"));
            }});
        }
    }

    @Override
    public void sendMessage(Integer userId, Integer enemyId, String message) {
        SqlHelper.prepareStatement(QUERY_SET_MESSAGE, pstmt -> {
            pstmt.setString(1, message);
            pstmt.setInt(2, userId);
            pstmt.setInt(3, enemyId);
            return pstmt.executeUpdate();
        });
    }
}

