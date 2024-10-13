package main.java.com.app.cinema.exception;

public class DataAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(String message, Throwable err) {
		super(message, err);
	}
}
