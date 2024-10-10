package main.java.com.app.cinema.data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import main.java.com.app.cinema.data.IConnection;
import main.java.com.app.cinema.data.PostgresConnection;
import main.java.com.app.cinema.exception.DataAccessException;
import main.java.com.app.cinema.model.Session;

public class SessionDAO implements IDAO<Session> {

	private IConnection postgresConnection;
	private static SessionDAO instance;

	private SessionDAO() {
		this.postgresConnection = new PostgresConnection();
	}

	public static SessionDAO getInstance() {
		if (instance == null)
			instance = new SessionDAO();

		return instance;
	}

	@Override
	public Session save(Session session) {

		String query = "INSERT INTO SESSION VALUES (?, ?, ?, ?, ?);";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setLong(1, session.getId());
			preparedStatement.setTimestamp(2, Timestamp.valueOf(session.getStartTime()));
			preparedStatement.setTimestamp(3, Timestamp.valueOf(session.getEndDateTime()));
			preparedStatement.setLong(4, session.getRoomId());
			preparedStatement.setLong(5, session.getMovieId());
			preparedStatement.execute();

		} catch (SQLException e) {
			throw new DataAccessException("Failed to save room", e);
		}

		return session;
	}

	@Override
	public Session update(Session session) {

		String query = "UPDATE SESSION SET START_DATE_TIME = ?, END_DATE_TIME = ?, ROOM_ID = ?, MOVIE_ID = ? WHERE ID = ?;";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setTimestamp(1, Timestamp.valueOf(session.getStartTime()));
			preparedStatement.setTimestamp(2, Timestamp.valueOf(session.getEndDateTime()));
			preparedStatement.setLong(3, session.getRoomId());
			preparedStatement.setLong(4, session.getMovieId());
			preparedStatement.setLong(5, session.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException("Failed to update room", e);
		}

		return session;
	}

	@Override
	public boolean deleteById(Long id) {
		String query = "DELETE FROM SESSION WHERE ID = ?";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setLong(1, id);

			return preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			throw new DataAccessException("Failed to delete room", e);
		}
	}

	@Override
	public Optional<Session> findById(Long id) {

		String query = "SELECT * FROM SESSION WHERE ID = ?;";
		Session session = null;

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				session = new Session();
				session.setId(resultSet.getLong("ID"));
				session.setStartTime(resultSet.getTimestamp("START_DATE_TIME").toLocalDateTime());
				session.setEndDateTime(resultSet.getTimestamp("END_DATE_TIME").toLocalDateTime());
				session.setMovieId(resultSet.getLong("MOVIE_ID"));
				session.setRoomId(resultSet.getLong("ROOM_ID"));
			}

		} catch (SQLException e) {
			throw new DataAccessException("Failed to find room", e);
		}

		return Optional.ofNullable(session);
	}

	@Override
	public List<Session> getAll() {

		List<Session> sessions = new ArrayList<Session>();
		String query = "SELECT * FROM SESSION";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Session session = new Session();
				session.setId(resultSet.getLong("ID"));
				session.setStartTime(resultSet.getTimestamp("START_DATE_TIME").toLocalDateTime());
				session.setEndDateTime(resultSet.getTimestamp("END_DATE_TIME").toLocalDateTime());
				session.setMovieId(resultSet.getLong("MOVIE_ID"));
				session.setRoomId(resultSet.getLong("ROOM_ID"));
				sessions.add(session);
			}

		} catch (SQLException e) {
			throw new DataAccessException("Failed to get rooms", e);
		}

		return sessions;
	}

}
