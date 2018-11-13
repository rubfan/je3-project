package ua.od.game.model;

import java.util.Map;


/**
 * @author DemianSH
 **/

public class CardEntity {

    private Integer id;
    private Integer cardId;
    private String groupId;
    private String name;
    private String description;
    private Map<String, Float> p1Buildings;
    private Map<String, Float> p2Buildings;
    private Map<String, Float> p1Resources;
    private Map<String, Float> p2Resources;
    private Map<String, Float> p1Upgrades;
    private Map<String, Float> p2Upgrades;
    private Map<String, Float> necessaryBuildings;
    private Map<String, Float> necessaryUpgrades;

    public CardEntity() {
    }

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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
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

    public Map<String, Float> getP1Buildings() {
        return p1Buildings;
    }

    public void setP1Buildings(Map<String, Float> p1Buildings) {
        this.p1Buildings = p1Buildings;
    }

    public Map<String, Float> getP2Buildings() {
        return p2Buildings;
    }

    public void setP2Buildings(Map<String, Float> p2Buildings) {
        this.p2Buildings = p2Buildings;
    }

    public Map<String, Float> getP1Resources() {
        return p1Resources;
    }

    public void setP1Resources(Map<String, Float> p1Resources) {
        this.p1Resources = p1Resources;
    }

    public Map<String, Float> getP2Resources() {
        return p2Resources;
    }

    public void setP2Resources(Map<String, Float> p2Resources) {
        this.p2Resources = p2Resources;
    }

    public Map<String, Float> getP1Upgrades() {
        return p1Upgrades;
    }

    public void setP1Upgrades(Map<String, Float> p1Upgrades) {
        this.p1Upgrades = p1Upgrades;
    }

    public Map<String, Float> getP2Upgrades() {
        return p2Upgrades;
    }

    public void setP2Upgrades(Map<String, Float> p2Upgrades) {
        this.p2Upgrades = p2Upgrades;
    }

    public Map<String, Float> getNecessaryBuildings() {
        return necessaryBuildings;
    }

    public void setNecessaryBuildings(Map<String, Float> necessaryBuildings) {
        this.necessaryBuildings = necessaryBuildings;
    }

    public Map<String, Float> getNecessaryUpgrades() {
        return necessaryUpgrades;
    }

    public void setNecessaryUpgrades(Map<String, Float> necessaryUpgrades) {
        this.necessaryUpgrades = necessaryUpgrades;
    }
}