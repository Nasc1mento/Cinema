package com.api.cinema.service;

import com.api.cinema.data.dao.SessionDAO;

public class SessionService {
	
	
	private final SessionDAO sessionDAO;
	
	public SessionService() {
		this.sessionDAO = SessionDAO.getInstance();
	}
}
