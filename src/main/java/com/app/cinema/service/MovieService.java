package main.java.com.app.cinema.service;

import java.util.List;
import java.util.Optional;

import main.java.com.app.cinema.data.dao.MovieDAO;
import main.java.com.app.cinema.model.Movie;

public class MovieService {

	private final MovieDAO movieDAO;

	public MovieService(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	public Movie save(Movie movie) {
		return this.save(movie);
	}

	public boolean deleteById(Long id) {
		return this.deleteById(id);
	}

	public Optional<Movie> findById(Long id) {
		return this.movieDAO.findById(id);
	}

	public List<Movie> findAll() {
		return this.movieDAO.findAll();
	}

}
