package ua.od.game.model;


import java.util.List;

public class NotificationEntity {

    private Integer id;
    private String name;
    private String description;

    private int notificationId;
    private int buildingId;
    private Float buildingNumber;
    private int resourceId;
    private Float resourceNumber;
    private int upgradeId;
    private Float upgradeNumber;

    private List<Float> buildingTrigger;
    private List<Float> resourceTrigger;
    private List<Float> upgradeTrigger;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public List<Float> getBuildingTrigger() {
        return buildingTrigger;
    }

    public void setExectBuildingTrigger(int buildingId, Float buildingNumber) {
        buildingTrigger.add(buildingId, buildingNumber);
    }

    public List<Float> getResourceTrigger() {
        return resourceTrigger;
    }

    public void setExectResourceTrigger(int resourceId, Float resourceNumber) {
        resourceTrigger.add(resourceId, resourceNumber);
    }

    public void setBuildingTrigger(int buildingId, Float buildingNumber) {

        buildingTrigger.set(buildingId,buildingNumber);
    }

    public List<Float> getUpgradeTrigger() {
        return upgradeTrigger;
    }

    public void setUpgradeTrigger(int upgradeId, Float upgradeNumber) {
        upgradeTrigger.add(upgradeId, upgradeNumber);
    }

    public int getBuildingId() {
        return buildingId;
    }

    protected void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getUpgradeId() {
        return upgradeId;
    }

    public void setUpgradeId(int upgradeId) {
        this.upgradeId = upgradeId;
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

    public Float getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Float buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Float getResourceNumber() {
        return resourceNumber;
    }

    public void setResourceNumber(Float resourceNumber) {
        this.resourceNumber = resourceNumber;
    }

    public Float getUpgradeNumber() {
        return upgradeNumber;
    }

    public void setUpgradeNumber(Float upgradeNumber) {
        this.upgradeNumber = upgradeNumber;
    }


    public String message() {

        String message = "name = " + getName() + ", description = " + getDescription();

        return message;


    }

}

