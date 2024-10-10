package main.java.model;

import java.util.Objects;

public class Chair extends Entity{

	private Long idRoom;
	private String number;
	private ChairType type;
	private boolean occupied;
	
	
	public Chair() {
		
	}
	
	public Chair(Long id, Long idRoom, String number, ChairType type, boolean occupied) {
		super(id);
		this.idRoom = idRoom;
		this.number = number;
		this.type = type;
		this.occupied = occupied;
	}

	public Long getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(Long idRoom) {
		this.idRoom = idRoom;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public ChairType getType() {
		return type;
	}

	public void setType(ChairType type) {
		this.type = type;
	}

	public void setOccupied(boolean ocupated) {
		this.occupied = ocupated;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Chair other = (Chair) obj;
		return Objects.equals(getId(), other.getId());
	}

	@Override
	public String toString() {
		return "Chair [id=" + getId() + ", number=" + number + ", occupied=" + occupied + ", idRoom=" + idRoom + "]";
	}

}
