package ua.od.game.repository.dao.impl;

import ua.od.game.model.UpgradeProductEntity;
import ua.od.game.repository.dao.UpgradeProductDao;
import ua.od.game.repository.helper.SqlHelper;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by Mazovskiy Mihail
 */

public class UpgradeProductDaoImpl implements UpgradeProductDao {

    private final String GET_UPGRADE_PRODUCT_LIST_QUERY = new StringBuilder()
            .append("UPDATE room ")
            .append("SET user_1_id = CASE WHEN user_1_id IS NULL ")
            .append("THEN ? ")
            .append("ELSE user_1_id END, ")
            .append("user_2_id = CASE WHEN user_1_id IS NOT NULL AND user_2_id IS NULL AND user_1_id <> ? ")
            .append("THEN ? ")
            .append("ELSE user_2_id END ")
            .append("WHERE id = ?")
            .toString();

    public List<UpgradeProductEntity> getUpgradeProductList() {
        return SqlHelper.prepareStatement(GET_UPGRADE_PRODUCT_LIST_QUERY, statementForUpgradeOfProducts -> {
            ResultSet upgradeOfProductsResultSet = statementForUpgradeOfProducts.executeQuery();
            List<UpgradeProductEntity> upgradeOfProduct = new LinkedList<>();
            while (upgradeOfProductsResultSet.next()) {
                upgradeOfProduct.add(new UpgradeProductEntity() {{
                    setId(upgradeOfProductsResultSet.getInt("id"));
                    setUpgradeId(upgradeOfProductsResultSet.getInt(""));
                    setUpgradeName(upgradeOfProductsResultSet.getString("id"));
                    setUpgradeDescription(upgradeOfProductsResultSet.getString("id"));
                    setBuildingId(upgradeOfProductsResultSet.getInt("id"));
                    setBuildingName(upgradeOfProductsResultSet.getString("id"));
                    setBuildingDescription(upgradeOfProductsResultSet.getString("id"));
                    setBuildingProductId(upgradeOfProductsResultSet.getInt("id"));
                    setResourceName(upgradeOfProductsResultSet.getString("id"));
                    setResourceDescription(upgradeOfProductsResultSet.getString("id"));
                    setResourceNumberPerSecond(upgradeOfProductsResultSet.getFloat("id"));
                }});
            }
            return upgradeOfProduct;
        });
    }
}