package com.api.cinema.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ApiExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {

		if (exception instanceof ResourceNotFoundException)
			return Response.status(Status.NOT_FOUND).entity(exception.getMessage()).build();

		if (exception instanceof IllegalArgumentException)
			return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();

		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Something wrong :(").build();
	}

}
