package com.api.cinema.service;

import java.util.List;

import com.api.cinema.data.dao.MovieDAO;
import com.api.cinema.exception.ResourceNotFoundException;
import com.api.cinema.model.Movie;
import com.api.cinema.model.MovieClassification;

public class MovieService {

	private final MovieDAO movieDAO;

	public MovieService() {
		this.movieDAO = MovieDAO.getInstance();
	}

	public Movie save(Movie movie) {
		return this.movieDAO.save(movie);
	}

	public Movie findById(Long id) {
		return this.movieDAO.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie with id: " + id + " not found"));
	}

	public List<Movie> findAll() {
		return this.movieDAO.findAll();
	}

	public Movie update(Long id, Movie movie) {
		return this.movieDAO.findById(id).map(m -> {
			movie.setId(id);
			return this.movieDAO.update(movie);
		}).orElseThrow(() -> new ResourceNotFoundException("Movie with id: " + id + " not found"));
	}

	public boolean deleteById(Long id) {
		return this.movieDAO.findById(id).map(m -> {
			return this.movieDAO.deleteById(id);
		}).orElseThrow(() -> new ResourceNotFoundException("Movie with id: " + id + " not found"));
	}

	public List<Movie> findAllByTitle(String title) {
		return this.movieDAO.findAllByTitle(title);
	}

	public List<Movie> findAllByClassification(int idClassification) {
		MovieClassification movieClassification = MovieClassification.fromCode(idClassification);
		return this.movieDAO.findAllByClassification(movieClassification);
	}

}