package ua.od.game.controller;

import ua.od.game.dto.AccountBuildingDto;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface AccountBuildingController {
    List<AccountBuildingDto> getAccountBuildingList(Integer accountId);
    Response clearAccountBuildingList(Integer accountId);
}
