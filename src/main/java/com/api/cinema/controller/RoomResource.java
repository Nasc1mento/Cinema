package com.api.cinema.controller;

import java.util.List;

import com.api.cinema.model.Room;
import com.api.cinema.service.RoomService;

import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/room")
public class RoomResource {
	
	private final RoomService roomService;
	
	
	public RoomResource() {
		this.roomService = new RoomService();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@Valid Room room) {
		
		room = this.roomService.save(room);
		return Response.ok(room).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam(value = "id") Long id) {
		
		Room room = roomService.findById(id);
		return Response.ok(room).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		
		List<Room> rooms = roomService.findAll();
		return Response.ok(rooms).build();
	}
}
