package main.java.data.dao;

import java.util.List;

import main.java.data.IConnection;
import main.java.data.PostgresConnection;
import main.java.model.Session;

public class SessionDAO implements IDAO<Session> {
	
	private IConnection postgresConnection;
	private static SessionDAO instance;
	
	
	private SessionDAO() {
		this.postgresConnection = new PostgresConnection();
	}
	
	public SessionDAO getInstance() {
		if (instance == null)
			instance = new SessionDAO();
		
		return instance;
	}
	

	@Override
	public Session save(Session entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session update(Session entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Session findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Session> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
