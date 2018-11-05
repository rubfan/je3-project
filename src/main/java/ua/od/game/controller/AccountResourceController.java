package ua.od.game.controller;

import ua.od.game.dto.AccountResourceDto;


import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface AccountResourceController {
    Response clearAccountResourceList(Integer accountId);
    List<AccountResourceDto> getAccountResourceList(Integer accountId);
}
