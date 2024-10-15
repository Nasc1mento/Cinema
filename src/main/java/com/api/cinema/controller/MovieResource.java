package com.api.cinema.controller;

import java.util.List;

import com.api.cinema.model.Movie;
import com.api.cinema.service.MovieService;

import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/movie")
public class MovieResource {

	private final MovieService movieService;

	public MovieResource() {
		this.movieService = new MovieService();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@Valid Movie movie) {
		
		movie = this.movieService.save(movie);
		return Response.ok(movie).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response get(@PathParam(value = "id") Long id) {
		
		Movie movie = movieService.findById(id);
		return Response.ok(movie).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		
		List<Movie> movies = movieService.findAll();
		return Response.ok(movies).build();
	}
	
	@PUT
	@Path(("/{id}"))
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam(value = "id") Long id, @Valid Movie movie) {
		movie = this.movieService.update(id, movie);
		return Response.ok(movie).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteById(@PathParam("id") Long id) {
		
		this.movieService.deleteById(id);
		return Response.noContent().build();
	};
}
