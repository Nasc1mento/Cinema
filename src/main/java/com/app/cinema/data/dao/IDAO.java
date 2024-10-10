package main.java.com.app.cinema.data.dao;

import java.util.List;
import java.util.Optional;

import main.java.com.app.cinema.model.Entity;

public interface IDAO <T extends Entity> {
	
	public T save(T entity);
	
	public T update(T entity);
	
	public boolean deleteById(Long id);
	
	public Optional<T> findById(Long id);
	
	public List<T> getAll();
	
}
