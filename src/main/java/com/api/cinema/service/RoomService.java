package com.api.cinema.service;

import com.api.cinema.data.dao.RoomDAO;

public class RoomService {
	
	private final RoomDAO roomDAO;
	
	
	public RoomService() {
		this.roomDAO = RoomDAO.getInstance();
	}
}
