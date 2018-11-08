package ua.od.game.controller;

import ua.od.game.dto.AccountUpgradeDto;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface AccountUpgradeController {
    List<AccountUpgradeDto> getAccountUpgradeList(Integer accountId);
}
