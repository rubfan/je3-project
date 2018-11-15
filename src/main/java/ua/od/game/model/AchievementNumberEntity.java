package ua.od.game.model;

public class AchievementNumberEntity {
    private Integer id;
    private Integer user_id;
    private Integer achievement_id;
    private Float number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getAchievement_id() {
        return achievement_id;
    }

    public void setAchievement_id(Integer achievement_id) {
        this.achievement_id = achievement_id;
    }

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "AchievementNumberEntity{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", achievement_id=" + achievement_id +
                ", number=" + number +
                '}';
    }
}
