package ua.od.game.model;

import java.io.Serializable;

/**
 * @author ruslan.gramatic
 */
public class RoomEntity implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private String user1Name;
    private String user2Name;

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

    public String getUser1Name() {
        return user1Name;
    }

    public void setUser1Name(String name) {
        this.user1Name = name;
    }

    public String getUser2Name() {
        return user2Name;
    }

    public void setUser2Name(String name) {
        this.user2Name = name;
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
