package main.java.com.app.cinema.data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import main.java.com.app.cinema.data.IConnection;
import main.java.com.app.cinema.data.PostgresConnection;
import main.java.com.app.cinema.exception.DataAccessException;
import main.java.com.app.cinema.model.Movie;
import main.java.com.app.cinema.model.MovieClassification;

public class MovieDAO implements IDAO<Movie> {

	private IConnection postgresConnection;
	private static MovieDAO instance;

	private MovieDAO() {
		this.postgresConnection = new PostgresConnection();
	}

	public static MovieDAO getInstance() {
		if (instance == null)
			instance = new MovieDAO();

		return instance;
	}

	@Override
	public Movie save(Movie movie) {

		String query = "INSERT INTO MOVIE (TITLE, DESCRIPTION, CLASSIFICATION_ID, DURATION) VALUES (?, ?, ?, ?, ?) RETURNING ID;";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setString(1, movie.getTitle());
			preparedStatement.setString(2, movie.getDescription());
			preparedStatement.setLong(4, movie.getClassification().getCode());
			preparedStatement.setInt(5, movie.getDuration());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next())
				movie.setId(resultSet.getLong("ID"));

		} catch (SQLException e) {
			throw new DataAccessException("Failed to save movie", e);
		}

		return movie;
	}

	@Override
	public Movie update(Movie movie) {

		String query = "UPDATE MOVIE SET TITLE = ?, DESCRIPTION = ?, MOVIE_CLASSIFICATION_ID = ?, DURATION = ? WHERE ID = ?;";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setString(1, movie.getTitle());
			preparedStatement.setString(2, movie.getDescription());
			preparedStatement.setLong(3, movie.getClassification().getCode());
			preparedStatement.setInt(4, movie.getDuration());
			preparedStatement.setLong(5, movie.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException("Failed to update movie", e);
		}

		return movie;
	}

	@Override
	public boolean deleteById(Long id) {

		String query = "DELETE FROM MOVIE WHERE ID = ?";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setLong(1, id);

			return preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			throw new DataAccessException("Failed to delete movie", e);
		}

	}

	@Override
	public Optional<Movie> findById(Long id) {

		String query = "SELECT * FROM MOVIE WHERE ID = ?;";
		Movie movie = null;

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				movie = new Movie();
				movie.setId(resultSet.getLong("ID"));
				movie.setTitle(resultSet.getString("TITLE"));
				movie.setDescription(resultSet.getString("DESCRIPTION"));
				movie.setClassification(MovieClassification.fromCode(resultSet.getInt("MOVIE_CLASSIFICATION_ID")));
				movie.setDuration(resultSet.getInt("DURATION"));
			}

		} catch (SQLException e) {
			throw new DataAccessException("Failed to find movie", e);
		}

		return Optional.ofNullable(movie);
	}

	@Override
	public List<Movie> findAll() {
		List<Movie> movies = new ArrayList<Movie>();
		String query = "SELECT * FROM MOVIE";

		try (PreparedStatement preparedStatement = this.postgresConnection.getConnection().prepareStatement(query)) {
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Movie movie = new Movie();
				movie.setId(resultSet.getLong("ID"));
				movie.setTitle(resultSet.getString("TITLE"));
				movie.setDescription(resultSet.getString("DESCRIPTION"));
				movie.setClassification(MovieClassification.fromCode(resultSet.getInt("MOVIE_CLASSIFICATION_ID")));
				movie.setDuration(resultSet.getInt("DURATION"));
				movies.add(movie);
			}

		} catch (SQLException e) {
			throw new DataAccessException("Failed to get movies", e);
		}

		return movies;

	}

}
