package ua.od.game.repository.dao.impl;

import ua.od.game.model.card.CardEntity;
import ua.od.game.model.card.CardGroupEntity;
import ua.od.game.model.card.CardProductEntity;
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
            " SELECT c.id card_id, c.name card_name, cp.card_group_id `group_id`, c.description card_desc " +
                    " FROM Card c " +
                    " LEFT JOIN Card_Product cp ON c.id = cp.card_id " +
                    " WHERE cp.card_group_id IS NOT NULL " +
                    " ORDER BY c.id;";

    private static final String QUERY_RESOURCE =
            "SELECT cp.card_id, cr1.resource_id player1_id, cr1.number player1_number, cr2.resource_id player2_id, " +
                    " cr2.number player2_number " +
                    " FROM Card_Product cp " +
                    " LEFT JOIN Card_Resource cr1 ON cp.p1_set_resource = cr1.set_id " +
                    " LEFT JOIN Card_Resource cr2 ON cp.p2_set_resource = cr2.set_id " +
                    " ORDER BY cp.card_id;";

    private static final String QUERY_BUILDING =
            "SELECT cp.card_id, cb1.building_id player1_id, cb1.number player1_number, cb2.building_id player2_id, " +
                    " cb2.number player2_number, ns.building_id necessary_id, ns.number necessary_number " +
                    " FROM Card_Product cp " +
                    " LEFT JOIN Card_Building cb1 ON cp.p1_set_building = cb1.set_id " +
                    " LEFT JOIN Card_Building cb2 ON cp.p2_set_building = cb2.set_id " +
                    " LEFT JOIN Card_Building ns ON cp.necessary_building_set = ns.set_id " +
                    " ORDER BY cp.card_id;";

    private static final String QUERY_UPGRADE =
            "SELECT cp.card_id, cu1.upgrade_id player1_id, cu1.number player1_number, cu2.upgrade_id player2_id, " +
                    " cu2.number player2_number, ns.upgrade_id necessary_id, ns.number necessary_number " +
                    " FROM Card_Product cp " +
                    " LEFT JOIN Card_Upgrade cu1 ON cp.p1_set_upgrade = cu1.set_id " +
                    " LEFT JOIN Card_Upgrade cu2 ON cp.p2_set_upgrade = cu2.set_id " +
                    " LEFT JOIN Card_Upgrade ns ON cp.necessary_upgrade_set = ns.set_id " +
                    " ORDER BY cp.card_id;";

    @Override
    public List<CardEntity> getAllCardList() {
        return SqlHelper.createStatement(statment -> {
            ResultSet resultCards = statment.executeQuery(QUERY_CARD);
            List<CardEntity> cards = fillCards(resultCards);//create main collection Cards
            ResultSet resultGroups = statment.executeQuery("SELECT id, name, description FROM Card_Group;");
            List<CardGroupEntity> groups = fillGroups(resultGroups);
            ResultSet resultResources = statment.executeQuery(QUERY_RESOURCE);
            //create collection CardProducts objects and fill its HashMaps Resources
            List<CardProductEntity> products = manipulQueryResource(resultResources);
            ResultSet resultBuildings = statment.executeQuery(QUERY_BUILDING);
            //only fill collection CardProducts HashMaps Buildings
            manipulQueryBuildings(resultBuildings, products);
            ResultSet resultUpgrades = statment.executeQuery(QUERY_UPGRADE);
            //only fill collection CardProducts HashMaps Upgrades
            manipulQueryUpgrades(resultUpgrades, products);
            matchGroupToCards(cards, groups);
            matchProductToCards(cards, products);
            return cards;
        });
    }

    private List<CardEntity> fillCards(ResultSet resl) throws SQLException {
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

    private List<CardGroupEntity> fillGroups(ResultSet resl) throws SQLException {
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

    private void matchGroupToCards(List<CardEntity> cards, List<CardGroupEntity> groupSet) {
        cards.forEach((CardEntity) -> {
            groupSet.forEach((CardGroupEntity) -> {
                if (CardGroupEntity.getId() == CardEntity.getGroupId()) {
                    CardEntity.setGroup(CardGroupEntity);
                }
            });
        });
    }

    private void matchProductToCards(List<CardEntity> cards, List<CardProductEntity> productSet) {
        cards.forEach((CardEntity) -> {
            productSet.forEach((CardProductEntity) -> {
                if (CardProductEntity.getCardId() == CardEntity.getId()) {
                    CardEntity.setProduct(CardProductEntity);
                }
            });
        });
    }

    private List<CardProductEntity> manipulQueryResource(ResultSet resl) throws SQLException {
        List<CardProductEntity> productSet = new ArrayList<>();
        Map<Integer, Float> player1Map = null;
        Map<Integer, Float> player2Map = null;
        Integer curentId = 1;
        while (resl.next()) {
            if (curentId != resl.getInt("card_id")) {
                productSet.add(fillProductResources(curentId, player1Map, player2Map));
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
        productSet.add(fillProductResources(curentId, player1Map, player2Map));
        return productSet;
    }

    private void manipulQueryBuildings(ResultSet resl, List<CardProductEntity> productSet) throws SQLException {
        Map<Integer, Float> player1Map = null;
        Map<Integer, Float> player2Map = null;
        Map<Integer, Float> necessaryMap = null;
        Integer curentId = 1;
        while (resl.next()) {
            if (curentId != resl.getInt("card_id")) {
                matchBuildingsToProducts(curentId, player1Map, player2Map, necessaryMap, productSet);
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
        matchBuildingsToProducts(curentId, player1Map, player2Map, necessaryMap, productSet);
    }

    private void manipulQueryUpgrades (ResultSet resl, List<CardProductEntity> productSet) throws SQLException {
        Map<Integer, Float> player1Map = null;
        Map<Integer, Float> player2Map = null;
        Map<Integer, Float> necessaryMap = null;
        Integer curentId = 1;
        while (resl.next()) {
            if (curentId != resl.getInt("card_id")) {
                matchResourceToProducts(curentId, player1Map, player2Map, necessaryMap, productSet);
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
        matchResourceToProducts(curentId, player1Map, player2Map, necessaryMap, productSet);
    }

    private CardProductEntity fillProductResources(Integer id, Map<Integer, Float> player1, Map<Integer, Float> player2) {
        CardProductEntity cardProduct = new CardProductEntity() {{
            setCardId(id);
            setP1Resources(player1);
            setP2Resources(player2);
        }};
        return cardProduct;
    }

    private void matchBuildingsToProducts(Integer id, Map<Integer, Float> player1, Map<Integer, Float> player2,
                                          Map<Integer, Float> necessary, List<CardProductEntity> cardProductExmp) {
        cardProductExmp.forEach((CardProductEntity) -> {
            if (CardProductEntity.getCardId() == id) {
                CardProductEntity.setP1Buildings(player1);
                CardProductEntity.setP2Buildings(player2);
                CardProductEntity.setNecessaryBuildings(necessary);
            }
        });
    }

    private void matchResourceToProducts(Integer id, Map<Integer, Float> player1, Map<Integer, Float> player2,
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