package ua.od.game.model;

public class UpgradeNumberEntity {
    private Integer upgradeId;
    private Float number;

    public Integer getUpgradeId() {
        return upgradeId;
    }

    public void setUpgradeId(Integer upgradeId) {
        this.upgradeId = upgradeId;
    }

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "UpgradeNumberEntity{" +
                "upgradeId=" + upgradeId +
                ", number=" + number +
                '}';
    }
}
