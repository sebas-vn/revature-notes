package com.revature;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
	
	private final String theatreName; // we will initialize inside of the constructor
	private List<Seat> seats = new ArrayList<>();
	
	/**
	 * When do you use an ArrayList over a LinkedList and vice versa
	 * 
	 *  ArrayList:
	 *  Best for SEARCHING: is done in O(1)
	 *  Worst for INSERTING (and deleting): done in O(n) linear time
	 *  
	 *  LionkedList
	 *  Best for INSERTING/DELETING: O(1) constant time (because LinkedList consists of nodes that have addresses)
	 *  Worst for: SEARCHING sometimes O(n) other times more complex....
	 *
	 */
	
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;
		
		int lastRow = 'A' + (numRows - 1);
		
		for (char row = 'A'; row <= lastRow; row++) {
			// nested for loop for each row, to make seats for each row
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				
				seats.add(seat);
			}
		}
	}
	
	public String getTheatreName() {
		return theatreName;
	}
	
	public void getSeats() {
		for (Seat seat: seats) {
			System.out.println(seat.getSeatNumber());
		}
	}
	
	// BRUTE FORCE ALGORITHM - Check every single seat to check if it's the one I wanto to reserve
	public boolean reserveSeat(String seatNumber) {
		Seat requestedSeat = null;
		
		for (Seat seat: seats) {
			if (seat.getSeatNumber().equals(seatNumber) ) {
				requestedSeat = seat;
				break;
			}
		}
		
		if (requestedSeat == null) {
			System.out.println("There is no seat" + seatNumber);
			return false;
		}
		
		return requestedSeat.reserve();
	}
	
	// Binary reserve seat algorithm
	public boolean reserveSeatBinary(String seatNumber) {
		int low = 0;
		int high = seats.size();
		
		while (low <= high) {
			
			// capture the middle value
			int mid = (low + high) / 2;
			
			// use the middle value to caprture the midlle seat of the row
			Seat midVal = seats.get(mid);
			
			// we have to check is the seatNumber passed through  greater than or less than the midVal
			int cmp = midVal.getSeatNumber().compareTo(seatNumber);
			
			// 0 if equal, -1 if less than, 1 if greater than
			
			if (cmp < 0) {
				low = mid + 1;
			} else if (cmp > 0) {
				high = mid - 1;
			} else {
				return seats.get(mid).reserve();
			}
		}
		
		System.out.println();
		return false;
	}
	
	/**
	 * Comparable is a special interface that allows us to define the order of a user-defined class
	 * @author ron
	 *
	 */
	// this is a nested class
	private class Seat implements Comparable<Seat>{ // Comparable is an interface we use to define order within a user-created class, 
													//Specify the type of object we are comparing	
		
		private final String seatNumber; // 
		private boolean reserved = false;
		
		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public String getSeatNumber() {
			return seatNumber;
		}
		
		public boolean reserve() {
			
			if (!this.reserved) {
				this.reserved = true;
				System.out.println("Reservation of seat " + seatNumber + " reserved.");
				
				return true;
			} else {
				return false;
			}
		}
		
		// This is how we define if a seat is greater than or less than another
		@Override
		public int compareTo(Seat seat) {
			return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
		}
			
	}
	
	

}
