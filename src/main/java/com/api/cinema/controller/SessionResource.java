package com.api.cinema.controller;

import com.api.cinema.service.SessionService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/session")
public class SessionResource {
	
	
	private final SessionService sessionService;
	
	public SessionResource() {
		this.sessionService = new SessionService();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		return Response.ok().build();
	}
	
}
