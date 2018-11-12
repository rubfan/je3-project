package ua.od.game.model;

import java.io.Serializable;

public class UpgradeProductEntity implements Serializable {

    private Integer id;
    private Integer upgradeId;
    private String upgradeName;
    private String upgradeDescription;
    private Integer buildingId;
    private String buildingName;
    private String buildingDescription;
    private Integer buildingProductId;
    private String resourceName;
    private String resourceDescription;
    private Float resourceUpgradePercent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUpgradeId() {
        return upgradeId;
    }

    public void setUpgradeId(Integer upgradeId) {
        this.upgradeId = upgradeId;
    }

    public String getUpgradeName() {
        return upgradeName;
    }

    public void setUpgradeName(String upgradeName) {
        this.upgradeName = upgradeName;
    }

    public String getUpgradeDescription() {
        return upgradeDescription;
    }

    public void setUpgradeDescription(String upgradeDescription) {
        this.upgradeDescription = upgradeDescription;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingDescription() {
        return buildingDescription;
    }

    public void setBuildingDescription(String buildingDescription) {
        this.buildingDescription = buildingDescription;
    }

    public Integer getBuildingProductId() {
        return buildingProductId;
    }

    public void setBuildingProductId(Integer buildingProductId) {
        this.buildingProductId = buildingProductId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public Float getResourceUpgradePercent() {
        return resourceUpgradePercent;
    }

    public void setResourceUpgradePercent(Float resourceUpgradePercent) {
        this.resourceUpgradePercent = resourceUpgradePercent;
    }
}