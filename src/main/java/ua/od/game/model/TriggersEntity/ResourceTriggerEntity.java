package ua.od.game.model.TriggersEntity;


public class ResourceTriggerEntity {

    private int notificationId;
    private int resourceId;
    private Float resourceNumber;

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public Float getResourceNumber() {
        return resourceNumber;
    }

    public void setResourceNumber(Float resourceNumber) {
        this.resourceNumber = resourceNumber;
    }
}
