package com.api.cinema.controller;

import com.api.cinema.service.RoomService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/room")
public class RoomResource {
	
	private final RoomService roomService;
	
	public RoomResource() {
		this.roomService = new RoomService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		return Response.ok().build();
	}
}
