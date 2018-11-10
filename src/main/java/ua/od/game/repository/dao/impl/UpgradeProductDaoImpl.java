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
            .append("SELECT upgrade_product.id, ")
                   .append("upgrade.id AS upgrade_id, upgrade.name AS upgrade_name, upgrade.description AS upgrade_description, ")
                   .append("building.id AS building_id, building.name AS building_name, building.description AS building_description, ")
                   .append("resource.id AS resource_id, resource.name AS resource_name, resource.description AS resource_description, ")
                   .append("upgrade_product.percent ")
            .append("FROM upgrade_product ")
                 .append("INNER JOIN upgrade ON upgrade_product.upgrade_id = upgrade.id ")
                 .append("INNER JOIN building ON upgrade_product.building_id = building.id ")
                 .append("INNER JOIN resource ON upgrade_product.resource_id = resource.id " )
            .append("ORDER BY upgrade_product.id ASC;")
            .toString();

    public List<UpgradeProductEntity> getUpgradeProductList() {
        return SqlHelper.prepareStatement(GET_UPGRADE_PRODUCT_LIST_QUERY, statementForUpgradeOfProducts -> {
            ResultSet upgradeOfProductsResultSet = statementForUpgradeOfProducts.executeQuery();
            List<UpgradeProductEntity> upgradeOfProduct = new LinkedList<>();
            while (upgradeOfProductsResultSet.next()) {
                upgradeOfProduct.add(new UpgradeProductEntity() {{
                    setId(upgradeOfProductsResultSet.getInt("id"));
                    setUpgradeId(upgradeOfProductsResultSet.getInt("upgrade_id"));
                    setUpgradeName(upgradeOfProductsResultSet.getString("upgrade_name"));
                    setUpgradeDescription(upgradeOfProductsResultSet.getString("upgrade_description"));
                    setBuildingId(upgradeOfProductsResultSet.getInt("building_id"));
                    setBuildingName(upgradeOfProductsResultSet.getString("building_name"));
                    setBuildingDescription(upgradeOfProductsResultSet.getString("building_description"));
                    setBuildingProductId(upgradeOfProductsResultSet.getInt("resource_id"));
                    setResourceName(upgradeOfProductsResultSet.getString("resource_name"));
                    setResourceDescription(upgradeOfProductsResultSet.getString("resource_description"));
                    setResourceUpgradePercent(upgradeOfProductsResultSet.getFloat("percent"));
                }});
            }
            return upgradeOfProduct;
        });
    }
}