package ua.od.game.model;

import java.util.List;
import java.util.Map;

/**@author Mazovskiy Mihail
 **/

public class CardEntity {

    private Integer id;
    private Integer cardId;
    private Integer groupId;
    private String name;
    private String description;
    private Map<Integer, Float> p1Building;
    private Map<Integer, Float> p2Building;
    private Map<Integer, Float> p1Resource;
    private Map<Integer, Float> p2Resource;
    private Map<Integer, Float> p1Upgrade;
    private Map<Integer, Float> p2Upgrade;
    private Map<Integer, Float> necessaryBuilding;
    private Map<Integer, Float> necessaryUpgrade;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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

    public Map<Integer, Float> getP1Building() {
        return p1Building;
    }

    public void setP1Building(Map<Integer, Float> p1Building) {
        this.p1Building = p1Building;
    }

    public Map<Integer, Float> getP2Building() {
        return p2Building;
    }

    public void setP2Building(Map<Integer, Float> p2Building) {
        this.p2Building = p2Building;
    }

    public Map<Integer, Float> getP1Resource() {
        return p1Resource;
    }

    public void setP1Resource(Map<Integer, Float> p1Resource) {
        this.p1Resource = p1Resource;
    }

    public Map<Integer, Float> getP2Resource() {
        return p2Resource;
    }

    public void setP2Resource(Map<Integer, Float> p2Resource) {
        this.p2Resource = p2Resource;
    }

    public Map<Integer, Float> getP1Upgrade() {
        return p1Upgrade;
    }

    public void setP1Upgrade(Map<Integer, Float> p1Upgrade) {
        this.p1Upgrade = p1Upgrade;
    }

    public Map<Integer, Float> getP2Upgrade() {
        return p2Upgrade;
    }

    public void setP2Upgrade(Map<Integer, Float> p2Upgrade) {
        this.p2Upgrade = p2Upgrade;
    }

    public Map<Integer, Float> getNecessaryBuilding() {
        return necessaryBuilding;
    }

    public void setNecessaryBuilding(Map<Integer, Float> necessaryBuilding) {
        this.necessaryBuilding = necessaryBuilding;
    }

    public Map<Integer, Float> getNecessaryUpgrade() {
        return necessaryUpgrade;
    }

    public void setNecessaryUpgrade(Map<Integer, Float> necessaryUpgrade) {
        this.necessaryUpgrade = necessaryUpgrade;
    }

}