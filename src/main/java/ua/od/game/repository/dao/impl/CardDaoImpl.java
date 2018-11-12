package ua.od.game.repository.dao.impl;

import ua.od.game.model.CardEntity;
import ua.od.game.model.RoomEntity;
import ua.od.game.repository.dao.CardDao;

import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by Mazovskiy Mihail
 */
public class CardDaoImpl implements CardDao {

    private final String GET_CARD_LIST_QUERY = new StringBuilder()
            .append("SELECT card_product.card_id, card_group_id,\n" +
                    "  GROUP_CONCAT(DISTINCT card_product.p1_building_id) AS p1_building_id,\n" +
                    "  GROUP_CONCAT(DISTINCT card_product.p1_building_number) AS p1_building_number,\n" +
                    "  GROUP_CONCAT(DISTINCT card_product.p2_building_id) AS p2_building_id,\n" +
                    "  GROUP_CONCAT(DISTINCT card_product.p2_building_number) AS p2_building_number,\n" +
                    "\n" +
                    "  GROUP_CONCAT(DISTINCT card_product.p1_upgrade_id) AS p1_upgrade_id,\n" +
                    "  GROUP_CONCAT(DISTINCT card_product.p1_upgrade_number) AS p1_upgrade_number,\n" +
                    "  GROUP_CONCAT(DISTINCT card_product.p2_upgrade_id) AS p2_upgrade_id,\n" +
                    "  GROUP_CONCAT(DISTINCT card_product.p2_upgrade_number) AS p2_upgrade_number,\n" +
                    "\n" +
                    "  GROUP_CONCAT(DISTINCT card_product.p1_resource_id) AS p1_resource_id,\n" +
                    "  GROUP_CONCAT(DISTINCT card_product.p1_resource_number) AS p1_resource_number,\n" +
                    "  GROUP_CONCAT(DISTINCT card_product.p2_resource_id) AS p2_resource_id,\n" +
                    "  GROUP_CONCAT(DISTINCT card_product.p2_resource_number) AS p2_resource_number,\n" +
                    "\n" +
                    "  GROUP_CONCAT(DISTINCT necessary_building_id) AS necessary_building_id,\n" +
                    "  GROUP_CONCAT(DISTINCT necessary_building_number) AS necessary_building_number,\n" +
                    "  GROUP_CONCAT(DISTINCT necessary_upgrade_id) AS necessary_upgrade_id,\n" +
                    "  GROUP_CONCAT(DISTINCT necessary_upgrade_number) AS necessary_upgrade_number\n" +
                    "FROM card_product GROUP BY card_id")
            .toString();

    public List<CardEntity> getAllCardList() {
        return SqlHelper.prepareStatement(GET_CARD_LIST_QUERY, statementForRoomList -> {
            ResultSet cardResultSet = statementForRoomList.executeQuery();
            List<CardEntity> card = new LinkedList<>();
            while (cardResultSet.next()) {

            }
            return card;
        });
    }
}
