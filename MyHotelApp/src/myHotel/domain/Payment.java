package myHotel.domain;

public class Payment {
	
	private String paymentPayerType;
	private int playerId;
	private int amount;
	
	private Customer madeBy;
	
	public Payment() {
		this.paymentPayerType = null;
		this.playerId = 0;
		this.amount = 0;
	}
	
	public Payment(String paymentPayerType, int payerId, int amount) {
		this.paymentPayerType = paymentPayerType;
		this.playerId = payerId;
		this.amount = amount;
	}
	
	public boolean checkDiscount(String paymentType) {
		return true;
	}
	
	public int getTotal() {
		return 0;
	}

	public String getPaymentPayerType() {
		return paymentPayerType;
	}

	public void setPaymentPayerType(String paymentPayerType) {
		this.paymentPayerType = paymentPayerType;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Customer getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(Customer madeBy) {
		this.madeBy = madeBy;
	}
}
