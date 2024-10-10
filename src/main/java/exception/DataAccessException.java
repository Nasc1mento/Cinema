package main.java.exception;

public class DataAccessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DataAccessException(String message, Throwable err) {
		super(message, err);
	}
}
