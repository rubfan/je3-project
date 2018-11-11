package ua.od.game.model;

import java.util.List;

/**@author Mazovskiy Mihail
 **/

public class CardEntity {

    private Integer id;
    private Integer cardId;
    private Integer groupId;
    private String name;
    private String description;
    private Map p1Building;
    private List<P2Building> p2Building;
    private List<P1Resource> p1Resource;
    private List<P2Resource> p2Resource;
    private List<P1Upgrade> p1Upgrade;
    private List<P2Upgrade> p2Upgrade;
    private List<NecessaryBuilding> necessaryBuilding;
    private List<NecessaryUpgrade> necessaryUpgrade;

    class Map {

        Integer id;
        Float number;
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

    public List<P1Building> getP1Building() {
        return p1Building;
    }

    public void setP1Building(List<P1Building> p1Building) {
        this.p1Building = p1Building;
    }

    public List<P2Building> getP2Building() {
        return p2Building;
    }

    public void setP2Building(List<P2Building> p2Building) {
        this.p2Building = p2Building;
    }

    public List<P1Resource> getP1Resource() {
        return p1Resource;
    }

    public void setP1Resource(List<P1Resource> p1Resource) {
        this.p1Resource = p1Resource;
    }

    public List<P2Resource> getP2Resource() {
        return p2Resource;
    }

    public void setP2Resource(List<P2Resource> p2Resource) {
        this.p2Resource = p2Resource;
    }

    public List<P1Upgrade> getP1Upgrade() {
        return p1Upgrade;
    }

    public void setP1Upgrade(List<P1Upgrade> p1Upgrade) {
        this.p1Upgrade = p1Upgrade;
    }

    public List<P2Upgrade> getP2Upgrade() {
        return p2Upgrade;
    }

    public void setP2Upgrade(List<P2Upgrade> p2Upgrade) {
        this.p2Upgrade = p2Upgrade;
    }

    public List<NecessaryBuilding> getNecessaryBuilding() {
        return necessaryBuilding;
    }

    public void setNecessaryBuilding(List<NecessaryBuilding> necessaryBuilding) {
        this.necessaryBuilding = necessaryBuilding;
    }

    public List<NecessaryUpgrade> getNecessaryUpgrade() {
        return necessaryUpgrade;
    }

    public void setNecessaryUpgrade(List<NecessaryUpgrade> necessaryUpgrade) {
        this.necessaryUpgrade = necessaryUpgrade;
    }
}