package ua.od.game.controller;

import ua.od.game.dto.MessageDto;

import javax.servlet.http.Cookie;
import javax.ws.rs.core.Response;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface MessageController {
    List<MessageDto> getMessageList();
    Response sendMessage(MessageDto message, Cookie cookie);
    List<MessageDto> getRoomMessageList(Cookie cookie);
}
