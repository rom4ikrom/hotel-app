package myHotel.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company extends Contact implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int companyNo;
	
	public Company() {
		
	}
	
	public Company(int compnayNo, String name, int tel, String email, String address, String postcode) {
		super(name, tel, email, address, postcode);
		this.companyNo = compnayNo;
	}
	
	/**
	 * Composition between Company and Payment
	 */
	
	private List<Payment> payments = new ArrayList<>();
	
	public void addPayment(Payment p) {
		payments.add(p);
	}
	
	public void cancelPayment(Payment p) {
		payments.remove(p);
	}
	
	public List<Payment> getPayments(int customerID) {
		return payments;
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub	
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
}
