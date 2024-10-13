package main.java.com.app.cinema.service;

import java.util.List;
import java.util.Optional;

import main.java.com.app.cinema.data.dao.ChairDAO;
import main.java.com.app.cinema.model.Chair;

public class ChairService {
	
	private final ChairDAO chairDAO;

	public ChairService(ChairDAO chairDAO) {
		this.chairDAO = chairDAO;
	}

	public Chair save(Chair movie) {
		return this.save(movie);
	}

	public boolean deleteById(Long id) {
		return this.deleteById(id);
	}

	public Optional<Chair> findById(Long id) {
		return this.chairDAO.findById(id);
	}

	public List<Chair> findAll() {
		return this.chairDAO.findAll();
	}
}
