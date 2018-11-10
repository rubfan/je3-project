package ua.od.game.repository.dao.impl;

import ua.od.game.model.CardEntity;
import ua.od.game.repository.dao.CardDao;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**@author DemianSH
 **/

public class CardDaoImpl implements CardDao {

    private static final String ALL_CARDS_INF =
            "SELECT cp.id, c.name card_name, cg.name card_group, CONCAT(cg.description,'/',c.description) description," +
                    "b1.name p1_building, b2.name p2_building, cp.p1_building_number, cp.p2_building_number," +
                    "bns.name necessary_building,cp.necessary_building_number necessary_number, u1.name p1_upgrade," +
                    "u2.name p2_upgrade, cp.p1_upgrade_number, cp.p2_upgrade_number,uns.name necessary_upgrade," +
                    "cp.necessary_upgrade_number, r1.name p1_resource, r2.name p2_resource, cp.p1_resource_number," +
                    "cp.p2_resource_number " +
                    "FROM Card_Product cp " +
                    "LEFT OUTER JOIN Card c ON cp.card_id = c.id " +
                    "LEFT OUTER JOIN Card_Group cg ON cp.card_group_id = cg.id " +
                    "LEFT OUTER JOIN Building b1 ON cp.p1_building_id = b1.id " +
                    "LEFT OUTER JOIN Building b2 ON cp.p2_building_id = b2.id " +
                    "LEFT OUTER JOIN Building bns ON cp.necessary_building_id = bns.id " +
                    "LEFT OUTER JOIN Upgrade u1 ON cp.p1_upgrade_id = u1.id " +
                    "LEFT OUTER JOIN Upgrade u2 ON cp.p2_upgrade_id = u2.id " +
                    "LEFT OUTER JOIN Upgrade uns ON cp.necessary_upgrade_id = uns.id " +
                    "LEFT OUTER JOIN Resource r1 ON cp.p1_resource_id = r1.id " +
                    "LEFT OUTER JOIN Resource r2 ON cp.p2_resource_id = r2.id;";

    @Override
    public List<CardEntity> getAllCardList() {
        return SqlHelper.createStatement(statment -> {
            ResultSet result = statment.executeQuery(ALL_CARDS_INF);
            List<CardEntity> cards = new ArrayList<>();
            while(result.next()){
                cards.add(new CardEntity(){{
                    setId(result.getInt("id"));
                    setName(result.getString("card_name"));
                    setGroup(result.getString("card_group"));
                    setDescription(result.getString("description"));
                    setP1Building(result.getString("p1_building"));
                    setP2Building(result.getString("p2_building"));
                    setP1BuildingNumber(result.getFloat("p1_building_number"));
                    setP2BuildingNumber(result.getFloat("p2_building_number"));
                    setNecessaryBuilding(result.getString("necessary_building"));
                    setNecessaryBuildingNumber(result.getFloat("necessary_building_number"));
                    setP1Upgrade(result.getString("p1_upgrade"));
                    setP2Upgrade(result.getString("p2_upgrade"));
                    setP1UpgradeNumber(result.getFloat("p1_upgrade_number"));
                    setP2UpgradeNumber(result.getFloat("p2_upgrade_number"));
                    setNecessaryUpgrade(result.getString("necessary_upgrade"));
                    setNecessaryUpgradeNumber(result.getFloat("necessary_upgrade_number"));
                    setP1Resource(result.getString("p1_resource"));
                    setP2Resource(result.getString("p2_resource"));
                    setP1ResourceNumber(result.getFloat("p1_resource_number"));
                    setP2ResourceNumber(result.getFloat("p2_resource_number"));
                }});
            }
            return cards;
        });
    }
}
