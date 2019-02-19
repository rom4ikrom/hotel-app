package myHotel.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer extends Contact implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerID;
	
	private String username;
	private String password;
	
	public Customer() {
		
	}
	
	public Customer(String name, int tel, String email, String address, String postcode) {
		super(name, tel, email, address, postcode);
	}
	
	/**
	 * Composition between Customer and Booking
	 */
	
	//list of bookings
	private List<Booking> bookings = new ArrayList<>();
	
	//add a new booking
	public void addBooking(Booking b) {
		bookings.add(b);
	}
	
	//remove a booking
	public void removeBooking(Booking b) {
		bookings.remove(b);
	}
	
	//get a list of bookings
	public List<Booking> getBookings(int customerID) {
		return bookings;
	}
	
	/**
	 * Composition between Customer and Payment
	 */
	
	private List<Payment> payments = new ArrayList<>();
	
	public void addPayment(Payment p) {
		payments.add(p);
	}
	
	public void removePayment(Payment p) {
		payments.remove(p);
	}
	
	public List<Payment> getPayments(int customerID) {
		return payments;
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}

}

