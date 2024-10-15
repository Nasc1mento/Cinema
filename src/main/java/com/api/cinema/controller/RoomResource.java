package com.api.cinema.controller;

import com.api.cinema.service.RoomService;

import jakarta.ws.rs.Path;

@Path("/room")
public class RoomResource {
	
	private final RoomService roomService;
	
	public RoomResource() {
		this.roomService = new RoomService();
	}
}
