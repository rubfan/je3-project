package ua.od.game.controller.impl;

import ua.od.game.controller.RoomController;
import ua.od.game.dto.UserRoomDto;
import ua.od.game.dto.RoomDto;
import ua.od.game.service.RoomService;

import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ruslan.gramatic
 */
@Path("/room")
public class RoomControllerImpl implements RoomController {

    @Inject
    public RoomService roomService;

    @GET
    @Path("list")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<RoomDto> getAllRoomList() {
        List<RoomDto> roomList = roomService.getRoomList();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, roomList.toString());
        return roomList;
    }

    @GET
    @Path("user/list")
    public List<UserRoomDto> getUserRoomList() {
        return Collections.emptyList(); //TODO: we need to return this list with correct data
    }

    @GET
    @Path("{roomId}/user/{userId}/join")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response joinRoom(@PathParam("roomId") Integer roomId, @PathParam("userId") Integer userId) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"room=" + roomId);
        roomService.joinRoom(roomId, userId);
        return Response.status(200).entity("User Entered").build();
    }

    @GET
    @Path("{roomId}/user/{userId}/leave")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response leaveRoom(@PathParam("roomId") Integer roomId, @PathParam("userId") Integer userId) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"room=" + roomId);
        roomService.leaveRoom(userId);
        return Response.status(200).entity("User Left").build();
    }
}

