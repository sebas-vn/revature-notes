package com.revature;

public class App {
	
	public static void main(String[] args) {
		Theatre theatre = new Theatre("Ford's Theatre", 8, 12);
		
		theatre.getSeats();
		
		// I want to reserve a seat
		
		// Enter the seat number, must go through a method in the SEAT class to check
		
		if (theatre.reserveSeat("G11")) {
		} else {
			System.out.println("Seat is already reserved, sorry");
		}
		
		if (theatre.reserveSeat("G11")) {
		} else {
			System.out.println("Seat is already reserved, sorry");
		}
		
		if (theatre.reserveSeat("G10")) {
		} else {
			System.out.println("Seat is already reserved, sorry");
		}
	}

}
