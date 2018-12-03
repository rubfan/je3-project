package ua.od.game.model;

import java.util.Map;

public class BuildingEntity {
    private Integer id;
    private String name;
    private String description;
    private Map<Integer,Float> resource;

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

    public Map<Integer, Float> getResource() {
        return resource;
    }

    public void setResource(Map<Integer, Float> resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return new String("Building: " +
                "id = " + getId() +
                " name = " + getName() +
                " description = " + getDescription());
    }
}
