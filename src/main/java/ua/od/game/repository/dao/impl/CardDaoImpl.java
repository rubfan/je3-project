package ua.od.game.repository.dao.impl;

import ua.od.game.model.card.CardEntity;
import ua.od.game.model.card.CardGroupEntity;
import ua.od.game.model.card.CardProductEntity;
import ua.od.game.repository.dao.CardDao;
import ua.od.game.repository.dao.Matching;
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
            " SELECT c.id card_id, c.name, c.description desc " +
                    " FROM Card c " +
                    " LEFT JOIN Card_Product cp ON c.id = cp.card_id " +
                    " ORDER BY card_id;";

    private static final String QUERY_GROUP =
            "SELECT cp.card_id, cg.name, cg.description desc " +
                    " FROM Card_Product cp " +
                    " LEFT JOIN Card_Group cg ON cp.card_group_id = cg.id;";

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
            List<CardEntity> cardList = fillCards(resultCards);//create main collection Cards
            ResultSet resultGroups = statment.executeQuery(QUERY_GROUP);
            List<CardGroupEntity> groupList = fillGroups(resultGroups);
            ResultSet resultResources = statment.executeQuery(QUERY_RESOURCE);
            //create collection CardProducts objects and fill its HashMaps Resources
            List<CardProductEntity> productList = queryProcessResource(resultResources);
            ResultSet resultBuildings = statment.executeQuery(QUERY_BUILDING);
            //only match collection CardProducts HashMaps Buildings
            CardDaoImpl cdi = new CardDaoImpl();
            queryProcess(resultBuildings, productList, cdi::matchBuildingsToProducts);
            ResultSet resultUpgrades = statment.executeQuery(QUERY_UPGRADE);
            //only match collection CardProducts HashMaps Upgrades
            queryProcess(resultUpgrades, productList, cdi::matchUpgradesToProducts);
            matchGroupToCards(cardList, groupList);
            matchProductToCards(cardList, productList);
            return cardList;
        });
    }

    private List<CardEntity> fillCards(ResultSet resl) throws SQLException {
        List<CardEntity> cardList = new ArrayList<>();
        while (resl.next()) {
            cardList.add(new CardEntity() {{
                setCardId(resl.getInt("card_id"));
                setName(resl.getString("name"));
                setDescription(resl.getString("desc"));
            }});
        }
        return cardList;
    }

    private List<CardGroupEntity> fillGroups(ResultSet resl) throws SQLException {
        List<CardGroupEntity> groupList = new ArrayList<>();
        while (resl.next()) {
            groupList.add(new CardGroupEntity() {{
                setCardId(resl.getInt("card_id"));
                setName(resl.getString("name"));
                setDescription(resl.getString("desc"));
            }});
        }
        return groupList;
    }

    private void matchGroupToCards(List<CardEntity> cards, List<CardGroupEntity> groupSet) {
        cards.forEach((CardEntity) -> {
            groupSet.forEach((CardGroupEntity) -> {
                if (CardGroupEntity.getCardId().equals(CardEntity.getCardId())) {
                    CardEntity.setGroup(CardGroupEntity);
                }
            });
        });
    }

    private void matchProductToCards(List<CardEntity> cards, List<CardProductEntity> productSet) {
        cards.forEach((CardEntity) -> {
            productSet.forEach((CardProductEntity) -> {
                if (CardProductEntity.getCardId().equals(CardEntity.getCardId())) {
                    CardEntity.setProduct(CardProductEntity);
                }
            });
        });
    }

    private List<CardProductEntity> queryProcessResource(ResultSet resl) throws SQLException {
        List<CardProductEntity> productList = new ArrayList<>();
        Map<Integer, Float> player1Map = null;
        Map<Integer, Float> player2Map = null;
        Integer curentId = 1;
        while (resl.next()) {
            if (curentId != resl.getInt("card_id")) {
                productList.add(fillProductResources(curentId, player1Map, player2Map));
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
        productList.add(fillProductResources(curentId, player1Map, player2Map));
        return productList;
    }

    private void queryProcess(ResultSet resl, List<CardProductEntity> productList, Matching mP) throws SQLException {
        Map<Integer, Float> player1Map = null;
        Map<Integer, Float> player2Map = null;
        Map<Integer, Float> necessaryMap = null;
        Integer curentId = 1;
        while (resl.next()) {
            if (curentId != resl.getInt("card_id")) {
                mP.matchToProducts(curentId, player1Map, player2Map, necessaryMap, productList);
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
        mP.matchToProducts(curentId, player1Map, player2Map, necessaryMap, productList);
    }



    private CardProductEntity fillProductResources(Integer id, Map<Integer, Float> player1, Map<Integer, Float> player2) {
        CardProductEntity productList = new CardProductEntity() {{
            setCardId(id);
            setP1Resources(player1);
            setP2Resources(player2);
        }};
        return productList;
    }

    private void matchBuildingsToProducts(Integer id, Map<Integer, Float> player1, Map<Integer, Float> player2,
                                                 Map<Integer, Float> necessary, List<CardProductEntity> productList) {
        productList.forEach((CardProductEntity) -> {
            if (CardProductEntity.getCardId().equals(id)) {
                CardProductEntity.setP1Buildings(player1);
                CardProductEntity.setP2Buildings(player2);
                CardProductEntity.setNecessaryBuildings(necessary);
            }
        });
    }

    private void matchUpgradesToProducts(Integer id, Map<Integer, Float> player1, Map<Integer, Float> player2,
                                         Map<Integer, Float> necessary, List<CardProductEntity> productList) {
        productList.forEach((CardProductEntity) -> {
            if (CardProductEntity.getCardId().equals(id)) {
                CardProductEntity.setP1Upgrades(player1);
                CardProductEntity.setP2Upgrades(player2);
                CardProductEntity.setNecessaryUpgrades(necessary);
            }
        });
    }
}