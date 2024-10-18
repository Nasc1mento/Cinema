package com.api.cinema.service;

import java.util.List;

import com.api.cinema.data.dao.SessionDAO;
import com.api.cinema.exception.ResourceNotFoundException;
import com.api.cinema.model.Session;

public class SessionService {

	private final SessionDAO sessionDAO;

	public SessionService() {
		this.sessionDAO = SessionDAO.getInstance();
	}

	public Session save(Session session) {
		return this.sessionDAO.save(session);
	}

	public List<Session> findAll() {
		return this.sessionDAO.findAll();
	}

	public Session update(Long id, Session session) {
		return this.sessionDAO.findById(id).map(c -> {
			session.setId(id);
			return this.sessionDAO.update(session);
		}).orElseThrow(() -> new ResourceNotFoundException("Session with id: " + id + " not found"));
	}

	public Session findById(Long id) {
		return this.sessionDAO.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Session with id " + id + " not found"));
	}

	public boolean deleteById(Long id) {
		return this.sessionDAO.findById(id).map(m -> {
			return this.sessionDAO.deleteById(id);
		}).orElseThrow(() -> new ResourceNotFoundException("Session with id: " + id + " not found"));
	}
}
