package ua.od.game.controller;

import ua.od.game.dto.AccountDto;

/**
 * @author ruslan.gramatic
 */
public interface AccountController {
    AccountDto getAccount(Integer accountId);
}
