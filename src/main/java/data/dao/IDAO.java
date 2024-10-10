package main.java.data.dao;

import java.util.List;

import main.java.model.Entity;

public interface IDAO <T extends Entity> {
	
	public T save(T entity);
	
	public T update(T entity);
	
	public boolean deleteById(Long id);
	
	public T findById(Long id);
	
	public List<T> getAll();
	
}
