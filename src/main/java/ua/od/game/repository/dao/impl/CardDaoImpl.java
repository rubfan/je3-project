package ua.od.game.repository.dao.impl;

import ua.od.game.model.cardEntity.CardEntity;
import ua.od.game.model.cardEntity.CardGroupEntity;
import ua.od.game.model.cardEntity.CardProductEntity;
import ua.od.game.repository.dao.CardDao;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DemianSH
 **/

public class CardDaoImpl implements CardDao {

    private static final String QUERY_CARD =
            " SELECT c.id card_id, c.name card_name, cp.card_group_id `group_id`, c.description card_desc\n" +
                    " FROM Card c \n" +
                    " LEFT JOIN Card_Product cp ON c.id = cp.card_id\n" +
                    " WHERE cp.card_group_id IS NOT NULL\n" +
                    " ORDER BY c.id;";

    private static final String QUERY_RESOURCE =
            "SELECT cp.card_id, cr1.resource_id player1_id, cr1.number player1_number, cr2.resource_id player2_id,\n" +
                    "       cr2.number player2_number\n" +
                    "FROM Card_Product cp\n" +
                    "LEFT JOIN Card_Resource cr1 ON cp.p1_set_resource_id = cr1.resource_set_id\n" +
                    "LEFT JOIN Card_Resource cr2 ON cp.p2_set_resource_id = cr2.resource_set_id\n" +
                    "ORDER BY cp.card_id;\n";

    private static final String QUERY_BUILDING =
            "SELECT cp.card_id, cb1.building_id player1_id, cb1.number player1_number, cb2.building_id player2_id,\n" +
                    "       cb2.number player2_number, ns.building_id necessary_id," +
                    " ns.number necessary_number\n" +
                    "FROM Card_Product cp\n" +
                    "LEFT JOIN Card_Building cb1 ON cp.p1_set_building_id = cb1.building_set_id\n" +
                    "LEFT JOIN Card_Building cb2 ON cp.p2_set_building_id = cb2.building_set_id\n" +
                    "LEFT JOIN Card_Building ns ON cp.necessary_building_set_id = ns.building_set_id\n" +
                    "ORDER BY cp.card_id;\n";

    private static final String QUERY_UPGRADE =
            "SELECT cp.card_id, cu1.upgrade_id player1_id, cu1.number player1_number, cu2.upgrade_id player2_id,\n" +
                    "       cu2.number player2_number, ns.upgrade_id necessary_id," +
                    " ns.number necessary_number\n" +
                    "FROM Card_Product cp\n" +
                    "LEFT JOIN Card_Upgrade cu1 ON cp.p1_set_upgrade_id = cu1.upgrade_set_id\n" +
                    "LEFT JOIN Card_Upgrade cu2 ON cp.p2_set_upgrade_id = cu2.upgrade_set_id\n" +
                    "LEFT JOIN Card_Upgrade ns ON cp.necessary_upgrade_set_id = ns.upgrade_set_id\n" +
                    "ORDER BY cp.card_id;\n";

    @Override
    public List<CardEntity> getAllCardList() {
        return SqlHelper.createStatement(statment -> {
            ResultSet resultCards = statment.executeQuery(QUERY_CARD);
            List<CardEntity> card = setCard(resultCards);//create main collection Cards
            ResultSet resultGroups = statment.executeQuery("SELECT id, name, description FROM Card_Group;");
            List<CardGroupEntity> group = setGroup(resultGroups);
            ResultSet resultResources = statment.executeQuery(QUERY_RESOURCE);
            //create collection CardProducts objects and fill its HashMaps Resources
            List<CardProductEntity> product = setProductResources(resultResources);
            ResultSet resultBuildings = statment.executeQuery(QUERY_BUILDING);
            //only fill collection CardProducts HashMaps Buildings
            setProductBuildings(resultBuildings, product);
            ResultSet resultUpgrades = statment.executeQuery(QUERY_UPGRADE);
            //only fill collection CardProducts HashMaps Upgrades
            setProductUpgrades(resultUpgrades, product);
            addGroupObj(card, group);
            addProductObj(card, product);
            return card;
        });
    }

    private List<CardEntity> setCard(ResultSet resl) throws SQLException {
        List<CardEntity> cardSet = new ArrayList<>();
        while (resl.next()) {
            cardSet.add(new CardEntity() {{
                setId(resl.getInt("card_id"));
                setName(resl.getString("card_name"));
                setDescription(resl.getString("card_desc"));
                setGroupId(resl.getInt("group_id"));
            }});
        }
        return cardSet;
    }

    private List<CardGroupEntity> setGroup(ResultSet resl) throws SQLException {
        List<CardGroupEntity> groupSet = new ArrayList<>();
        while (resl.next()) {
            groupSet.add(new CardGroupEntity() {{
                setId(resl.getInt("id"));
                setName(resl.getString("name"));
                setDescription(resl.getString("description"));
            }});
        }
        return groupSet;
    }

    private void addGroupObj(List<CardEntity> cards, List<CardGroupEntity> groupSet) {
        cards.forEach((CardEntity) -> {
            groupSet.forEach((CardGroupEntity) -> {
                if (CardGroupEntity.getId() == CardEntity.getGroupId()) {
                    CardEntity.setGroup(CardGroupEntity);
                }
            });
        });
    }

    private void addProductObj(List<CardEntity> cards, List<CardProductEntity> productSet) {
        cards.forEach((CardEntity) -> {
            productSet.forEach((CardProductEntity) -> {
                if (CardProductEntity.getCardId() == CardEntity.getId()) {
                    CardEntity.setProduct(CardProductEntity);
                }
            });
        });
    }

    private List<CardProductEntity> setProductResources(ResultSet resl) throws SQLException {
        List<CardProductEntity> productSet = new ArrayList<>();
        Map<Integer, Float> player1Map = null;
        Map<Integer, Float> player2Map = null;
        Integer curentId = 1;
        while (resl.next()) {
            if (curentId != resl.getInt("card_id")) {
                productSet.add(setResource(curentId, player1Map, player2Map));
            }
            if (player1Map == null || curentId != resl.getInt("card_id")) {
                player1Map = new HashMap<>();
            }
            player1Map.put(resl.getInt("player1_id"), resl.getFloat("player1_number"));
            if (player2Map == null || curentId != resl.getInt("card_id")) {
                player2Map = new HashMap<>();
            }
            player2Map.put(resl.getInt("player2_id"), resl.getFloat("player2_number"));

            curentId = resl.getInt("card_id");
        }
        productSet.add(setResource(curentId, player1Map, player2Map));
        return productSet;
    }

    private void setProductBuildings(ResultSet resl, List<CardProductEntity> productSet) throws SQLException {
        Map<Integer, Float> player1Map = null;
        Map<Integer, Float> player2Map = null;
        Map<Integer, Float> necessaryMap = null;
        Integer curentId = 1;
        while (resl.next()) {
            if (curentId != resl.getInt("card_id")) {
                setBuildings(curentId, player1Map, player2Map, necessaryMap, productSet);
            }

            if (player1Map == null || curentId != resl.getInt("card_id")) {
                player1Map = new HashMap<>();
            }
            player1Map.put(resl.getInt("player1_id"), resl.getFloat("player1_number"));

            if (player2Map == null || curentId != resl.getInt("card_id")) {
                player2Map = new HashMap<>();
            }
            player2Map.put(resl.getInt("player2_id"), resl.getFloat("player2_number"));

            if (necessaryMap == null || curentId != resl.getInt("card_id")) {
                necessaryMap = new HashMap<>();
            }
            necessaryMap.put(resl.getInt("necessary_id"), resl.getFloat("necessary_number"));

            curentId = resl.getInt("card_id");
        }
        setBuildings(curentId, player1Map, player2Map, necessaryMap, productSet);
    }

    private void setProductUpgrades(ResultSet resl, List<CardProductEntity> productSet) throws SQLException {
        Map<Integer, Float> player1Map = null;
        Map<Integer, Float> player2Map = null;
        Map<Integer, Float> necessaryMap = null;
        Integer curentId = 1;
        while (resl.next()) {
            if (curentId != resl.getInt("card_id")) {
                setUpgrades(curentId, player1Map, player2Map, necessaryMap, productSet);
            }

            if (player1Map == null || curentId != resl.getInt("card_id")) {
                player1Map = new HashMap<>();
            }
            player1Map.put(resl.getInt("player1_id"), resl.getFloat("player1_number"));

            if (player2Map == null || curentId != resl.getInt("card_id")) {
                player2Map = new HashMap<>();
            }
            player2Map.put(resl.getInt("player2_id"), resl.getFloat("player2_number"));

            if (necessaryMap == null || curentId != resl.getInt("card_id")) {
                necessaryMap = new HashMap<>();
            }
            necessaryMap.put(resl.getInt("necessary_id"), resl.getFloat("necessary_number"));

            curentId = resl.getInt("card_id");
        }
        setUpgrades(curentId, player1Map, player2Map, necessaryMap, productSet);
    }

    private CardProductEntity setResource(Integer id, Map<Integer, Float> player1, Map<Integer, Float> player2) {
        CardProductEntity cardProduct = new CardProductEntity() {{
            setCardId(id);
            setP1Resources(player1);
            setP2Resources(player2);
        }};
        return cardProduct;
    }

    private void setBuildings(Integer id, Map<Integer, Float> player1, Map<Integer, Float> player2,
                              Map<Integer, Float> necessary, List<CardProductEntity> cardProductExmp) {
        cardProductExmp.forEach((CardProductEntity) -> {
            if (CardProductEntity.getCardId() == id) {
                CardProductEntity.setP1Buildings(player1);
                CardProductEntity.setP2Buildings(player2);
                CardProductEntity.setNecessaryBuildings(necessary);
            }
        });
    }

    private void setUpgrades(Integer id, Map<Integer, Float> player1, Map<Integer, Float> player2,
                             Map<Integer, Float> necessary, List<CardProductEntity> cardProductExmp) {
        cardProductExmp.forEach((CardProductEntity) -> {
            if (CardProductEntity.getCardId() == id) {
                CardProductEntity.setP1Upgrades(player1);
                CardProductEntity.setP2Upgrades(player2);
                CardProductEntity.setNecessaryUpgrades(necessary);
            }
        });
    }
}