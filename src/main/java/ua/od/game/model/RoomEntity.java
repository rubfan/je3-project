package ua.od.game.model;

import java.io.Serializable;

/**
 * @author ruslan.gramatic
 */
public class RoomEntity implements Serializable {
    private Integer id;
    private String name;
    private String description;

    public RoomEntity() {}

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

    @Override
    public String toString() {
        return "RoomEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description +
                '}';
    }
}