package ua.od.game.repository.dao;

import ua.od.game.model.UpgradeProductEntity;
import java.util.List;

/**
 * @author Mazovskiy Mihail
 */
public interface UpgradeProductDao {
    List<UpgradeProductEntity> getUpgradeProductList();
}
