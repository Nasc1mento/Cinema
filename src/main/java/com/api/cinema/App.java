package com.api.cinema;

import java.util.HashSet;
import java.util.Set;

import com.api.cinema.controller.ChairResource;
import com.api.cinema.controller.MovieResource;
import com.api.cinema.controller.RoomResource;
import com.api.cinema.controller.SessionResource;
import com.api.cinema.exception.ApiExceptionMapper;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class App extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(MovieResource.class);
		classes.add(RoomResource.class);
		classes.add(ChairResource.class);
		classes.add(SessionResource.class);

		classes.add(ApiExceptionMapper.class);

		return classes;
	}

}
