package ua.od.game.model;


import ua.od.game.model.TriggersEntity.BuildingTriggerEntity;
import ua.od.game.model.TriggersEntity.ResourceTriggerEntity;
import ua.od.game.model.TriggersEntity.UpgradeTriggerEntity;

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

    private BuildingTriggerEntity buildingTrigger;
    private ResourceTriggerEntity resourceTrigger;
    private UpgradeTriggerEntity upgradeTrigger;

public NotificationEntity(){

}


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

    public BuildingTriggerEntity getBuildingTrigger() {
        return buildingTrigger;
    }

    public void setBuildingTrigger(BuildingTriggerEntity buildingTrigger) {
        this.buildingTrigger = buildingTrigger;
    }

    public ResourceTriggerEntity getResourceTrigger() {
        return resourceTrigger;
    }

    public void setResourceTrigger(ResourceTriggerEntity resourceTrigger) {
        this.resourceTrigger = resourceTrigger;
    }

    public UpgradeTriggerEntity getUpgradeTrigger() {
        return upgradeTrigger;
    }

    public void setUpgradeTrigger(UpgradeTriggerEntity upgradeTrigger) {
        this.upgradeTrigger = upgradeTrigger;
    }

    public void setUpgradeNumber(Float upgradeNumber) {
        this.upgradeNumber = upgradeNumber;
    }


    public String message() {

        String message = "name = " + getName() + ", description = " + getDescription();

        return message;


    }

}

