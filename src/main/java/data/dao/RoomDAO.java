package main.java.data.dao;

import java.util.List;

import main.java.data.IConnection;
import main.java.data.PostgresConnection;
import main.java.model.Room;

public class RoomDAO implements IDAO<Room> {
	
	private IConnection postgresConnection;
	private static RoomDAO instance;
	
	
	private RoomDAO() {
		this.postgresConnection = new PostgresConnection();
	}
	
	public RoomDAO getInstance() {
		if (instance == null)
			instance = new RoomDAO();
		
		return instance;
	}

	@Override
	public Room save(Room entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room update(Room entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Room findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
