package main.java.model;

public abstract class Entity {

	private Long id;
	
	public Entity() {
		
	}

	public Entity(Long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
