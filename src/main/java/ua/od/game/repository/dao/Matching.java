package ua.od.game.repository.dao;

import ua.od.game.model.card.CardProductEntity;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface Matching {
    void matchToProducts(Integer id, Map<Integer, Float> player1, Map<Integer, Float> player2,
                         Map<Integer, Float> necessary, List<CardProductEntity> cardProductExmp);
}
