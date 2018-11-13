package ua.od.game.model;

public class UpgradeNumberEntity {
    private Integer id;
    private Integer userId;
    private Integer upgradeId;
    private Float number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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
                "id=" + id +
                ", userId=" + userId +
                ", upgradeId=" + upgradeId +
                ", number=" + number +
                '}';
    }
}
