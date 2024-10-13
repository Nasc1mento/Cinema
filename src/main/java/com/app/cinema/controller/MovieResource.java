package main.java.com.app.cinema.controller;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import main.java.com.app.cinema.model.Movie;
import main.java.com.app.cinema.service.MovieService;

@Path("movie")
public class MovieResource {

	private final MovieService movieService;

	public MovieResource(MovieService movieService) {
		this.movieService = movieService;
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Movie create(@Valid Movie movie) {
		return this.movieService.save(movie);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Movie get(@PathParam(value = "id") Long id) {
		return this.movieService.findById(id).orElseThrow();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getAll() {
		return this.movieService.findAll();
	}
	
}
