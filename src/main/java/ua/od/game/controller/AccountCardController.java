package ua.od.game.controller;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface AccountCardController {
    List<Integer> getAllowAccountCardList(Integer accountId);
    Response applyCard(Integer accountId, Integer cardId);
}
