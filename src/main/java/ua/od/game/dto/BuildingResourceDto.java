package ua.od.game.dto;

/**
 * @author ruslan.gramatic
 */
public class BuildingResourceDto {
    private Integer resourceId;
    private Float numPerMin;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Float getNumPerMin() {
        return numPerMin;
    }

    public void setNumPerMin(Float numPerMin) {
        this.numPerMin = numPerMin;
    }

    @Override
    public String toString() {
        return "BuildingResourceDto{" +
                "resourceId=" + resourceId +
                ", numPerMin=" + numPerMin +
                '}';
    }
}
