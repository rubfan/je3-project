package ua.od.game.model.TriggersEntity;


public class UpgradeTriggerEntity {

    private int notificationId;
    private int upgradeId;
    private Float upgradeNumber;

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getUpgradeId() {
        return upgradeId;
    }

    public void setUpgradeId(int upgradeId) {
        this.upgradeId = upgradeId;
    }

    public Float getUpgradeNumber() {
        return upgradeNumber;
    }

    public void setUpgradeNumber(Float upgradeNumber) {
        this.upgradeNumber = upgradeNumber;
    }
}
