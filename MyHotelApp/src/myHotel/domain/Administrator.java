package myHotel.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//extends contact class - inheritance
@Entity
public class Administrator extends Contact implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	
	private DescriptionCategory dc;
	private PresentationEquipment pe;
	private Booking booking;
	
	public Administrator() {
		
	}
	
	public Administrator(int id, String name, int tel, String email, String address, String postcode) {
		super(name, tel, email, address, postcode);
		this.adminId = id;
	}
	
	//change the details of booking description category
	public DescriptionCategory manageDescriptionCategory(int bookingNo, int categoryNo) {
		return dc;
	}
	
	//change the room of presentation equipment
	public void movePresentationEquipment(int roomNo) {
		pe.setCurrentRoomNo(roomNo);
	}
	
	public Booking manageBooking(int bookingNo) {
		//get booking details from database
		return booking;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

}
