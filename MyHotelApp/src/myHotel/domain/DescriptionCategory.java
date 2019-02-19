package myHotel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DescriptionCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryNo;
	private String categoryName;
	private String categoryInfo;
	
	private Booking includesIn;
	
	public DescriptionCategory() {
		this.categoryNo = 0;
		this.categoryName = null;
		this.categoryInfo = null;
	}

	public DescriptionCategory(int categoryNo, String categoryName, String categoryInfo) {
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.categoryInfo = categoryInfo;
	}
	
	public String getCategoryInfo(int categoryNo) {
		return null;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryInfo() {
		return categoryInfo;
	}

	public void setCategoryInfo(String categoryInfo) {
		this.categoryInfo = categoryInfo;
	}

	public Booking getIncludesIn() {
		return includesIn;
	}

	public void setIncludesIn(Booking includesIn) {
		this.includesIn = includesIn;
	}

}
