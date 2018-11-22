package ua.od.game.model.card;

/**
 * @author DemianSH
 **/

public class CardEntity {

    private Integer cardId;
    private String name;
    private String description;
    private CardGroupEntity group;
    private CardProductEntity product;

    public CardEntity() {
    }

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

    public CardGroupEntity getGroup() {
        return group;
    }

    public void setGroup(CardGroupEntity group) {
        this.group = group;
    }

    public CardProductEntity getProduct() {
        return product;
    }

    public void setProduct(CardProductEntity product) {
        this.product = product;
    }
}