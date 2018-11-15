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

    private static final String ALL_CARDS_INF = "";

    @Override
    public List<CardEntity> getAllCardList() {


        return SqlHelper.createStatement(statment -> {
            ResultSet result = statment.executeQuery(ALL_CARDS_INF);
            List<CardEntity> cards = new ArrayList<>();
            while (result.next()) {
                cards.add(new CardEntity() {{
                    setId(result.getInt("id"));
                    setName(result.getString("card_name"));
                    setGroupId(result.getInt("card_group"));


                }});
            }
            return cards;
        });

    }

    private static Map<String, Float> setMap(String val1, float val2) {
        Map<String, Float> map = new HashMap<>();
        map.put(val1, val2);
        return map;
    }
}