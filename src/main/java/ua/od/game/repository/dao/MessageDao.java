package ua.od.game.repository.dao;

import ua.od.game.model.MessageEntity;

import java.util.List;

/**
 * @author AndreiDatc & DemianSH
 */

public interface MessageDao {
    List<MessageEntity> getMessages(Integer userId, Integer enemyId);

    void sendMessage(Integer userId, Integer enemyId, String message);
}
