package com.api.cinema.controller;

import java.util.List;

import com.api.cinema.model.Session;
import com.api.cinema.service.SessionService;

import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/session")
public class SessionResource {
	
	
	private final SessionService sessionService;
	
	public SessionResource() {
		this.sessionService = new SessionService();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@Valid Session session) {
		
		session = this.sessionService.save(session);
		return Response.ok(session).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam(value = "id") Long id) {
		
		Session room = sessionService.findById(id);
		return Response.ok(room).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		
		List<Session> sessions = sessionService.findAll();
		return Response.ok(sessions).build();
	}
	
}
