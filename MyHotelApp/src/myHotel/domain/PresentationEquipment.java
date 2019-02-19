package myHotel.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PresentationEquipment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int peNo;
	int currentRoomNo;
	
	public PresentationEquipment() {
		
	}
	
	public PresentationEquipment(int currentRoomNo) {
		this.currentRoomNo = currentRoomNo;
	}

	public int getCurrentRoomNo() {
		return currentRoomNo;
	}

	public void setCurrentRoomNo(int currentRoomNo) {
		this.currentRoomNo = currentRoomNo;
	}

}
