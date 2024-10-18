package com.api.cinema.service;

import java.util.List;

import com.api.cinema.data.dao.RoomDAO;
import com.api.cinema.exception.ResourceNotFoundException;
import com.api.cinema.model.Room;

public class RoomService {

	private final RoomDAO roomDAO;

	public RoomService() {
		this.roomDAO = RoomDAO.getInstance();
	}

	public Room save(Room room) {
		return this.roomDAO.save(room);
	}

	public List<Room> findAll() {
		return this.roomDAO.findAll();
	}

	public Room update(Long id, Room room) {
		return this.roomDAO.findById(id).map(c -> {
			room.setId(id);
			return this.roomDAO.update(room);
		}).orElseThrow(() -> new ResourceNotFoundException("Session with id: " + id + " not found"));
	}

	public Room findById(Long id) {
		return this.roomDAO.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Session with id: " + id + " not found"));
	}

	public boolean deleteById(Long id) {
		return this.roomDAO.findById(id).map(m -> {
			return this.roomDAO.deleteById(id);
		}).orElseThrow(() -> new ResourceNotFoundException("Session with id: " + id + " not found"));
	}
}
