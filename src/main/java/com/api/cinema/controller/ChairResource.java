package com.api.cinema.controller;

import java.util.List;

import com.api.cinema.model.Chair;
import com.api.cinema.service.ChairService;

import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/chair")
public class ChairResource {
	
	private final ChairService chairService;
	
	
	public ChairResource() {
		this.chairService = new ChairService();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@Valid Chair chair) {
		
		chair = this.chairService.save(chair);
		return Response.ok(chair).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam(value = "id") Long id) {
		
		Chair chair = chairService.findById(id);
		return Response.ok(chair).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		
		List<Chair> chairs = chairService.findAll();
		return Response.ok(chairs).build();
	}
}
