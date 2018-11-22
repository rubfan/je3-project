package ua.od.game.model.card;

/**
 * @author DemianSH
 **/

public class CardGroupEntity {

    private Integer cardId;
    private String name;
    private String description;

    public CardGroupEntity(){}

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}