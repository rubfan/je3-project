package ua.od.game.model.TriggersEntity;

public class BuildingTriggerEntity {

    private int notificationId;
    private int buildingId;
    private Float buildingNumber;

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public Float getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Float buildingNumber) {
        this.buildingNumber = buildingNumber;
    }
}
