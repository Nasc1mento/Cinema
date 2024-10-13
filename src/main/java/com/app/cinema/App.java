package main.java.com.app.cinema;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.core.Application;
import main.java.com.app.cinema.controller.MovieResource;

public class App extends Application {
	
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(MovieResource.class);	
        return classes;
    }
}
