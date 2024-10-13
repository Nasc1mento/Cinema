package main.java.com.app.cinema.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionMapper implements jakarta.ws.rs.ext.ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		
		return null;
		
	}

	
}
