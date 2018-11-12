package ua.od.game.controller;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface UserCardController {
    List<Integer> getAllowUserCardList(Integer userId);
    Response applyCard(Integer userId, Integer cardId);
}
