package main.java.data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import main.java.data.IConnection;
import main.java.data.PostgresConnection;
import main.java.exception.DataAccessException;
import main.java.model.Chair;
import main.java.model.ChairType;

public class ChairDAO implements IDAO<Chair> {

	private IConnection postgresConnection;
	private static ChairDAO instance;

	private ChairDAO() {
		this.postgresConnection = new PostgresConnection();
	}

	public static ChairDAO getInstance() {
		if (instance == null)
			instance = new ChairDAO();

		return instance;
	}

	@Override
	public Chair save(Chair chair) {

		String query = "INSERT INTO CHAIR VALUES (?, ?, ?, ?, ?);";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setLong(1, chair.getId());
			preparedStatement.setLong(2, chair.getIdRoom());
			preparedStatement.setString(3, chair.getNumber());
			preparedStatement.setInt(3, chair.getType().getCode());
			preparedStatement.setBoolean(4, chair.isOccupied());
			preparedStatement.execute();

		} catch (SQLException e) {
			throw new DataAccessException("Failed to save chair", e);
		}

		return chair;
	}

	@Override
	public Chair update(Chair chair) {

		String query = "UPDATE CHAIR SET NUMBER = ?, TYPE = ?, OCCUPIED = ?, ROOM_ID,  WHERE ID = ?;";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setString(1, chair.getNumber());
			preparedStatement.setLong(2, chair.getType().getCode());
			preparedStatement.setBoolean(3, chair.isOccupied());
			preparedStatement.setLong(4, chair.getIdRoom());
			preparedStatement.setLong(5, chair.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException("Failed to update chair", e);
		}

		return chair;
	}

	@Override
	public boolean deleteById(Long id) {

		String query = "DELETE FROM CHAIR WHERE ID = ?";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setLong(1, id);

			return preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			throw new DataAccessException("Failed to delete chair", e);
		}
	}

	@Override
	public Optional<Chair> findById(Long id) {
		String query = "SELECT * FROM CHAIR WHERE ID = ?;";
		Chair chair = null;

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				chair = new Chair();
				chair.setId(resultSet.getLong("ID"));
				chair.setIdRoom(resultSet.getLong("ID_ROOM"));
				chair.setNumber(resultSet.getString("NUMBER"));
				chair.setType(ChairType.fromCode(resultSet.getInt("TYPE_ID")));
				chair.setOccupied(resultSet.getBoolean("OCCUPIED"));
			}

		} catch (SQLException e) {
			throw new DataAccessException("Failed to find chair", e);
		}

		return Optional.ofNullable(chair);
	}

	@Override
	public List<Chair> getAll() {
		
		List<Chair> chairs = new ArrayList<Chair>();
		String query = "SELECT * FROM CHAIR";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Chair chair = new Chair();
				chair.setId(resultSet.getLong("ID"));
				chair.setIdRoom(resultSet.getLong("ROOM_ID"));
				chair.setNumber(resultSet.getString("NUMBER"));
				chair.setType(ChairType.fromCode(resultSet.getInt("TYPE_ID")));
				chair.setOccupied(resultSet.getBoolean("OCCUPIED"));
				chairs.add(chair);
			}

		} catch (SQLException e) {
			throw new DataAccessException("Failed to get chairs", e);
		}

		return chairs;
	}

}
