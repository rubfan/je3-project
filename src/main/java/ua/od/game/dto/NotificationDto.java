package ua.od.game.dto;

/**
 * @author ruslan.gramatic
 */
public class NotificationDto {
    private Integer id;
    private String name;
    private String description;

// ----------------------- ShC -------

    private int buildingId;
    private Float buildingNumber;
    private int resourceId;
    private Float resourceNumber;
    private int upgradeId;
    private Float upgradeNumber;



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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "NotificationDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
