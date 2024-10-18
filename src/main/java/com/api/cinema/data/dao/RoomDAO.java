package com.api.cinema.data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.api.cinema.data.IConnection;
import com.api.cinema.data.PostgresConnection;
import com.api.cinema.exception.DataAccessException;
import com.api.cinema.model.Room;

public class RoomDAO implements IDAO<Room> {
	
	
	private IConnection postgresConnection;
	private static RoomDAO instance;

	private RoomDAO() {
		this.postgresConnection = new PostgresConnection();
	}

	public static RoomDAO getInstance() {
		if (instance == null)
			instance = new RoomDAO();

		return instance;
	}

	@Override
	public Room save(Room room) {

		String query = "INSERT INTO ROOM (NAME, CAPACITY, ADDRESS) VALUES (?, ?, ?) RETURNING ID;";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setString(1, room.getName());
			preparedStatement.setInt(2, room.getCapacity());
			preparedStatement.setString(3, room.getAddress());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next())
				room.setId(resultSet.getLong("ID"));
			
		} catch (SQLException e) {
			throw new DataAccessException("Failed to save room");
		}

		return room;
	}

	@Override
	public Room update(Room room) {
		
		String query = "UPDATE ROOM SET NAME = ?, CAPACITY = ?, ADDRESS = ? WHERE ID = ?";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setString(1, room.getName());
			preparedStatement.setInt(2, room.getCapacity());
			preparedStatement.setString(3, room.getAddress());
			preparedStatement.setLong(4, room.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException("Failed to update room");
		}

		return room;
	}

	@Override
	public boolean deleteById(Long id) {

		String query = "DELETE FROM ROOM WHERE ID = ?";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setLong(1, id);

			return preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			throw new DataAccessException("Failed to delete room");
		}
	}

	@Override
	public Optional<Room> findById(Long id) {

		String query = "SELECT * FROM ROOM WHERE ID = ?;";
		Room room = null;

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				room = new Room();
				room.setId(resultSet.getLong("ID"));
				room.setName(resultSet.getString("NAME"));
				room.setCapacity(resultSet.getInt("CAPACITY"));
				room.setAddress(resultSet.getString("ADDRESS"));
			}

		} catch (SQLException e) {
			throw new DataAccessException("Failed to find room");
		}

		return Optional.ofNullable(room);
	}

	@Override
	public List<Room> findAll() {

		List<Room> rooms = new ArrayList<Room>();
		String query = "SELECT * FROM ROOM";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Room room = new Room();
				room.setId(resultSet.getLong("ID"));
				room.setName(resultSet.getString("NAME"));
				room.setAddress(resultSet.getString("ADDRESS"));
				room.setCapacity(resultSet.getInt("CAPACITY"));
				rooms.add(room);
			}

		} catch (SQLException e) {
			throw new DataAccessException("Failed to get rooms");
		}

		return rooms;
	}
}
