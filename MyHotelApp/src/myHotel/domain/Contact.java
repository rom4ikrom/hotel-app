package myHotel.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Contact implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="name")
	private String name;
	private int tel;
	private String email;
	private String address;
	private String postcode;
	
	public Contact() {
		name = "none";
		tel = 0;
		email = "none";
		address = "none";
		setPostcode("none");
	}
	
	public Contact(String name, int tel, String email, String address, String postcode) {
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.address = address;
		this.setPostcode(postcode);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	//method to register in the system
	public void register() {
		
	}

}
