package ua.od.game.repository.dao;

import ua.od.game.model.UpgradeNumberEntity;
import java.util.List;

public interface UserUpgradeDao {
    List<UpgradeNumberEntity>getUserUpgrades(Integer userId);
    boolean clearUserUpgrades(Integer userId);
    boolean prepareDefaultUserUpgrades(Integer userId);
}
