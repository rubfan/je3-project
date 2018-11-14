package ua.od.game.repository.dao;

import ua.od.game.model.BuildingEntity;
import ua.od.game.model.ResourceEntity;

import java.util.List;
import java.util.Map;

public interface BuildingDao {
    Map<BuildingEntity, Map<ResourceEntity,Float>> getAllBuildingList();
}
