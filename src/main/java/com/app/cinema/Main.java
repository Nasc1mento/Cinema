package main.java.com.app.cinema;

import main.java.com.app.cinema.data.dao.ChairDAO;
import main.java.com.app.cinema.data.dao.RoomDAO;
import main.java.com.app.cinema.model.Chair;
import main.java.com.app.cinema.model.ChairType;
import main.java.com.app.cinema.model.Room;

public class Main {
	public static void main(String[] args) {
		
		Room r = new Room("Sala1", 100, "Corredor 5");
		
		RoomDAO rd = RoomDAO.getInstance();
		
		System.out.println(rd.save(r));
		
		Chair c = new Chair(r.getId(), "A0", ChairType.DEFAULT, false);
		
		
		ChairDAO cd = ChairDAO.getInstance();
		
		System.out.println(cd.save(c));
	}
}
