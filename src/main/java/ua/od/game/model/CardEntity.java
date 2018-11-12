package ua.od.game.model;

/**@author DemianSH
 **/

public class CardEntity {
    private Integer id;
    private String name;
    private String group;
    private String description;
    private String p1Building;
    private String p2Building;
    private Float p1BuildingNumber;
    private Float p2BuildingNumber;
    private String necessaryBuilding;
    private Float necessaryBuildingNumber;
    private String p1Upgrade;
    private String p2Upgrade;
    private Float p1UpgradeNumber;
    private Float p2UpgradeNumber;
    private String necessaryUpgrade;
    private Float necessaryUpgradeNumber;
    private String p1Resource;
    private String p2Resource;
    private Float p1ResourceNumber;
    private Float p2ResourceNumber;

    public CardEntity() {}

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

    public String getGroup() {
        return group;
    }

    public void setGroup(String cardGroup) {
        this.group = cardGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getP1Building() {
        return p1Building;
    }

    public void setP1Building(String p1Building) {
        this.p1Building = p1Building;
    }

    public String getP2Building() {
        return p2Building;
    }

    public void setP2Building(String p2Building) {
        this.p2Building = p2Building;
    }

    public Float getP1BuildingNumber() {
        return p1BuildingNumber;
    }

    public void setP1BuildingNumber(Float p1BuildingNumber) {
        this.p1BuildingNumber = p1BuildingNumber;
    }

    public Float getP2BuildingNumber() {
        return p2BuildingNumber;
    }

    public void setP2BuildingNumber(Float p2BuildingNumber) {
        this.p2BuildingNumber = p2BuildingNumber;
    }

    public String getNecessaryBuilding() {
        return necessaryBuilding;
    }

    public void setNecessaryBuilding(String necessaryBuilding) {
        this.necessaryBuilding = necessaryBuilding;
    }

    public Float getNecessaryBuildingNumber() {
        return necessaryBuildingNumber;
    }

    public void setNecessaryBuildingNumber(Float necessaryBuildingNumber) {
        this.necessaryBuildingNumber = necessaryBuildingNumber;
    }

    public String getP1Upgrade() {
        return p1Upgrade;
    }

    public void setP1Upgrade(String p1Upgrade) {
        this.p1Upgrade = p1Upgrade;
    }

    public String getP2Upgrade() {
        return p2Upgrade;
    }

    public void setP2Upgrade(String p2Upgrade) {
        this.p2Upgrade = p2Upgrade;
    }

    public Float getP1UpgradeNumber() {
        return p1UpgradeNumber;
    }

    public void setP1UpgradeNumber(Float p1UpgradeNumber) {
        this.p1UpgradeNumber = p1UpgradeNumber;
    }

    public Float getP2UpgradeNumber() {
        return p2UpgradeNumber;
    }

    public void setP2UpgradeNumber(Float p2UpgradeNumber) {
        this.p2UpgradeNumber = p2UpgradeNumber;
    }

    public String getNecessaryUpgrade() {
        return necessaryUpgrade;
    }

    public void setNecessaryUpgrade(String necessaryUpgrade) {
        this.necessaryUpgrade = necessaryUpgrade;
    }

    public Float getNecessaryUpgradeNumber() {
        return necessaryUpgradeNumber;
    }

    public void setNecessaryUpgradeNumber(Float necessaryUpgradeNumber) {
        this.necessaryUpgradeNumber = necessaryUpgradeNumber;
    }

    public String getP1Resource() {
        return p1Resource;
    }

    public void setP1Resource(String p1Resource) {
        this.p1Resource = p1Resource;
    }

    public String getP2Resource() {
        return p2Resource;
    }

    public void setP2Resource(String p2Resource) {
        this.p2Resource = p2Resource;
    }

    public Float getP1ResourceNumber() {
        return p1ResourceNumber;
    }

    public void setP1ResourceNumber(Float p1ResourceNumber) {
        this.p1ResourceNumber = p1ResourceNumber;
    }

    public Float getP2ResourceNumber() {
        return p2ResourceNumber;
    }

    public void setP2ResourceNumber(Float p2ResourceNumber) {
        this.p2ResourceNumber = p2ResourceNumber;
    }
}
