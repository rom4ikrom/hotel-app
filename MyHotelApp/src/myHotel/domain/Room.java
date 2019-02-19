package myHotel.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int roomNo;
	private String roomType;
	private int price;
	private int roomsAvailable;
	private boolean booked;
	
	private final int singlePrice = 50;
	private final int doublePrice = 65;
	private final int functionPrice = 220;
	
	private int singleQnt = 10;
	private int doubleQnt = 25;
	private int functionaQnt = 3;
	
	
	public Room() {
		this.roomNo = 0;
		this.roomType = " ";
	}
	
	public Room(int roomNo, String roomType) {
		this.roomNo = roomNo;
		this.roomType = roomType.toLowerCase();
		
		if(this.roomType != null && this.roomType.equals("single")) {
			this.setPrice(singlePrice);
			this.roomsAvailable = singleQnt;
		} else if (this.roomType != null && this.roomType.equals("double")) {
			this.setPrice(doublePrice);
			this.roomsAvailable = doubleQnt;
		} else if (this.roomType != null && this.roomType.equals("function")) {
			this.setPrice(functionPrice);
			this.roomsAvailable = functionaQnt;
		}
		
	}
	
	public int checkAvailability() {
		return roomsAvailable;
	}
	
	public void setBooked() {
		if(roomsAvailable <= 0) {
			//throw an exception
		} else {
			this.booked = true;
			this.roomsAvailable = roomsAvailable - 1;
		}
	}
	
	public void setAvailable() {
		this.booked = false;
		this.roomsAvailable = roomsAvailable + 1;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomsAvailable() {
		return roomsAvailable;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
