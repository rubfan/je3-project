package ua.od.game.model;

import java.io.Serializable;

/**
 * @author ruslan.gramatic
 */
public class RoomEntity implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private String account1Name;
    private String account2Name;

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

    public String getAccount1Name() {
        return account1Name;
    }

    public void setAccount2Name(String name) {
        this.account1Name = name;
    }

    public String getAccount2Name() {
        return account2Name;
    }

    public void setAccount1Name(String name) {
        this.account1Name = name;
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
