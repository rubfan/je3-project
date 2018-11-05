package ua.od.game.dto;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public class BuildingDto {
    private Integer id;
    private String name;
    private String description;
    private List<BuildingResourceDto> buildingProductList;



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

    public List<BuildingResourceDto> getBuildingProductList() {
        return buildingProductList;
    }

    public void setBuildingProductList(List<BuildingResourceDto> buildingProductList) {
        this.buildingProductList = buildingProductList;
    }

    @Override
    public String toString() {
        return "BuildingDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", buildingProductList=" + buildingProductList +
                '}';
    }

}
