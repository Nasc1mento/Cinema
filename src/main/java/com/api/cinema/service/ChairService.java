package com.api.cinema.service;

import java.util.List;

import com.api.cinema.data.dao.ChairDAO;
import com.api.cinema.exception.ResourceNotFoundException;
import com.api.cinema.model.Chair;

public class ChairService {
	
private final ChairDAO chairDAO;
	
	public ChairService() {
		this.chairDAO = ChairDAO.getInstance();
	}
	
	public Chair save(Chair chair) {
		return this.chairDAO.save(chair);
	}
	
	public List<Chair> findAll() {
		return this.chairDAO.findAll();
	}
	
	public Chair update(Long id, Chair chair) {
		return this.chairDAO.findById(id).map(c -> {
			chair.setId(id);
			return this.chairDAO.update(chair);
		}).orElseThrow(() -> new ResourceNotFoundException("Chair with id: " + id + " not found"));
	}
	
	public Chair findById(Long id) {
		return this.findById(id);
	}
	
	public boolean deleteById(Long id) {
		return this.chairDAO.findById(id).map(m -> {
			return this.chairDAO.deleteById(id);
		}).orElseThrow(() -> new ResourceNotFoundException("Chair with id: "+ id + " not found"));
	}
}
