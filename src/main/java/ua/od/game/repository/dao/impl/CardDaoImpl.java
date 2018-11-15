package ua.od.game.repository.dao.impl;

import ua.od.game.model.CardEntity;
import ua.od.game.repository.dao.CardDao;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DemianSH
 **/

public class CardDaoImpl implements CardDao {

    private static final String QUERY_CARD_DESC =
            " SELECT c.id, c.name, cp.card_group_id, c.description, cg.description " +
            " FROM Card c " +
            " INNER JOIN Card_Product cp ON c.id = cp.card_id " +
            " INNER JOIN Card_Group cg ON cp.card_group_id = cg.id;";

    private static final String QUERY_CARD_BUILD =
            "SELECT cp.card_id, cb1.building_id, cb1.number, cb2.building_id, cb2.number, " +
                    "       cp.necessary_building_id, cp.necessary_building_number " +
                    " FROM Card_Product cp " +
                    " LEFT JOIN Card_Building cb1 ON cp.p1_set_building_id = cb1.set_id " +
                    " LEFT JOIN Card_Building cb2 ON cp.p2_set_building_id = cb2.set_id " +
                    " ORDER BY cp.card_id; ";

    private static final String QUERY_CARD_RESOURCE =
            "SELECT  cp.card_id, cr1.resource_id, cr1.number, cr2.resource_id, cr2.number " +
                    " FROM Card_Product cp " +
                    " LEFT JOIN Card_Resource cr1 ON cp.p1_set_resource_id = cr1.set_id " +
                    " LEFT JOIN Card_Resource cr2 ON cp.p2_set_building_id = cr2.set_id " +
                    " ORDER BY cp.card_id; ";

    private static final String QUERY_CARD_UPGRADE =
            "SELECT cp.card_id, cu1.upgrade_id, cu1.number, cu2.upgrade_id, cu2.number, " +
                    "       cp.necessary_upgrade_id, cp.necessary_upgrade_number " +
                    " FROM Card_Product cp " +
                    " LEFT JOIN Card_Upgrade cu1 ON cp.p1_set_upgrade_id = cu1.set_id " +
                    " LEFT JOIN Card_Upgrade cu2 ON cp.p2_set_upgrade_id = cu2.set_id " +
                    " ORDER BY cp.card_id;";

    @Override
    public List<CardEntity> getAllCardList() {
        return SqlHelper.createStatement(statment -> {
            ResultSet rsDesc = statment.executeQuery(QUERY_CARD_DESC);
            ResultSet rsBuild = statment.executeQuery(QUERY_CARD_BUILD);
            ResultSet rsResource = statment.executeQuery(QUERY_CARD_RESOURCE);
            ResultSet rsUpgrade = statment.executeQuery(QUERY_CARD_UPGRADE);
            List<CardEntity> cards = new ArrayList<>();
            while (rsDesc.next()) {
                cards.add(new CardEntity() {{
                    setId(rsDesc.getInt("c.id"));
                    setName(rsDesc.getString("c.name"));
                    setGroupId(rsDesc.getInt("cp.card_group_id"));
                    setCardDescription(rsDesc.getString("c.description"));
                    setGroupDescription(rsDesc.getString("cg.description"));
                    if(rsDesc.getInt("c.id") == rsBuild.getInt("card_id")){
                        setP1Buildings(setMap(rsBuild.getInt("cb1.building_id"),rsBuild.getFloat("cb1.number")));
                        setP2Buildings(setMap(rsBuild.getInt("cb2.building_id"),rsBuild.getFloat("cb2.number")));
                        setNecessaryBuildings(setMap(rsBuild.getInt("cp.necessary_building_id"),
                                                     rsBuild.getFloat("cp.necessary_building_number")));
                    }
                    if(rsDesc.getInt("c.id") == rsResource.getInt("cp.card_id")){
                        setP1Resources(setMap(rsResource.getInt("cr1.resource_id"),
                                              rsResource.getFloat("cr1.number")));
                        setP2Resources(setMap(rsResource.getInt("cr2.resource_id"),
                                              rsResource.getFloat("cr2.number")));
                    }
                    if(rsDesc.getInt("c.id") == rsUpgrade.getInt("cp.card_id")){
                        setP1Upgrades(setMap(rsUpgrade.getInt("cu1.upgrade_id"),rsUpgrade.getFloat("cu1.number")));
                        setP2Upgrades(setMap(rsUpgrade.getInt("cu2.upgrade_id"),rsUpgrade.getFloat("cu2.number")));
                        setNecessaryUpgrades(setMap(rsUpgrade.getInt("cp.necessary_upgrade_id"),
                                                    rsUpgrade.getFloat("cp.necessary_upgrade_number")));
                    }
                }});
            }
            return cards;
        });
    }

    private static Map<Integer, Float> setMap(Integer val1, float val2) {
        Map<Integer, Float> map = new HashMap<>();
        map.put(val1, val2);
        return map;
    }
}