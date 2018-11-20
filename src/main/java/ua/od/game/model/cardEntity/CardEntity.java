package ua.od.game.model.cardEntity;

import java.util.Map;


/**
 * @author DemianSH
 **/

public class CardEntity {

    private Integer id;
    private String name;
    private String description;
    private Integer groupId;
    private CardGroupEntity group;
    private CardProductEntity product;

    public CardEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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