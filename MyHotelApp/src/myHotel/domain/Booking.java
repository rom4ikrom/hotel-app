package myHotel.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

@Entity
public class Booking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int bookingNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CHECK_IN")
	private Date sDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CHECK_OUT")
	private Date eDate;
	private Room room;
	private int bookingPrice;
	
	
	private Customer madeBy;
	
	/**
	 * Aggregation with DescriptionCategory class
	 */
	private List<DescriptionCategory> categoriesList = new ArrayList<>();
	
	public Booking() {
		this.bookingNo = 0;
		this.sDate = null;
		this.eDate = null;
		this.room = null;
	}
	
	public Booking(int bookingNo, Date sDate, Date eDate, Room room) {
		this.bookingNo = bookingNo;
		this.sDate = sDate;
		this.eDate = eDate;
		this.room = room;
		
		//date converted to local date to get the difference between two day to determine the length of stay in the hotel
		LocalDate checkIn = sDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate checkOut = eDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		Period period = Period.between(checkIn, checkOut);
		
		this.bookingPrice = period.getDays() * room.getPrice();
	}

	public int getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	
	public Date getCheckInDate() {
		return sDate;
	}

	public void setCheckInDate(Date sDate) {
		this.sDate = sDate;
	}

	public Date getCheckOutDate() {
		return eDate;
	}

	public void setCheckOutDate(Date eDate) {
		this.eDate = eDate;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoomType(Room room) {
		this.room = room;
	}
	
	public int getBookingPrice() {
		return bookingPrice;
	}
	
	public void setBookingPrice(int bookingPrice) {
		this.bookingPrice = bookingPrice;
	}

	public Customer getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(Customer madeBy) {
		this.madeBy = madeBy;
	}
	
	public String getRoomType() {
		
		String roomType = room.getRoomType();
		
		char[] array = roomType.toCharArray();
		array[0] = Character.toUpperCase(array[0]);
		
		return new String(array);
	}

	public List<DescriptionCategory> getCategoriesList() {
		return categoriesList;
	}

	public void setCategoriesList(List<DescriptionCategory> categoriesList) {
		this.categoriesList = categoriesList;
	}
	
	public String toString() {
		return "bookingNo is: " + bookingNo + " Check In: " + sDate + " Check Out: " + eDate;
	}

}
