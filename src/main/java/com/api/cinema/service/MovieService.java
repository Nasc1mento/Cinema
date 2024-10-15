package com.api.cinema.service;

import java.util.List;

import com.api.cinema.data.dao.MovieDAO;
import com.api.cinema.exception.ResourceNotFoundException;
import com.api.cinema.model.Movie;

public class MovieService {

	private final MovieDAO movieDAO;

	public MovieService() {
		this.movieDAO = MovieDAO.getInstance();
	}

	public Movie save(Movie movie) {
		return this.movieDAO.save(movie);
	}

	public boolean deleteById(Long id) {
		return this.movieDAO.findById(id).map(movie -> {
			return this.movieDAO.deleteById(id);
		}).orElseThrow(() -> new ResourceNotFoundException("Movie with id: " + id + " not found"));
	}

	public Movie findById(Long id) {
		return this.movieDAO.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie with id: " + id + " not found"));
	}

	public List<Movie> findAll() {
		return this.movieDAO.findAll();
	}

	public Movie findByName(String name) {
		return this.movieDAO.findByName(name).
				orElseThrow(() -> new ResourceNotFoundException("Movie with name: " + name + " not found"));
	}
}
