package myHotel.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cardType;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cardNo;
	boolean valid;
	
	public Card() {
		
	}
	
	public Card(String cardType, int cardNo, boolean valid) {
		this.cardType = cardType;
		this.cardNo = cardNo;
		this.valid = valid;
	}
	
	public boolean verify(int cardNo) {
		return true;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	
}
