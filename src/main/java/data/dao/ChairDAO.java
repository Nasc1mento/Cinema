package main.java.data.dao;

import java.util.List;

import main.java.data.IConnection;
import main.java.data.PostgresConnection;
import main.java.model.Chair;

public class ChairDAO implements IDAO<Chair> {
	
	
	private IConnection postgresConnection;
	private static ChairDAO instance;
	
	
	private ChairDAO() {
		this.postgresConnection = new PostgresConnection();
	}
	
	public ChairDAO getInstance() {
		if (instance == null)
			instance = new ChairDAO();
		
		return instance;
	}
	
	@Override
	public Chair save(Chair entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chair update(Chair entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Chair findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Chair> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
