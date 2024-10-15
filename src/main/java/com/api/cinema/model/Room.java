package com.api.cinema.model;

import java.util.Objects;

public class Room extends Entity {

	private String name;
	private Integer capacity;
	private String address;

	public Room() {

	}

	public Room(String name, Integer capacity, String address) {
		this.name = name;
		this.capacity = capacity;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(getId(), other.getId());
	}

	@Override
	public String toString() {
		return "Room [id=" + getId() + ", name=" + name + ", capacity=" + capacity + ", address=" + address + "]";
	}
}
