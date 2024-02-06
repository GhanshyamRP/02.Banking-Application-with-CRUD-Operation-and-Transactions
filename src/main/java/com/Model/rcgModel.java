package com.Model;

public class rcgModel {

	private long mobile;
	private int amount;
	
	public rcgModel() {
		
	}
	
	public rcgModel(long mobile, int amount) {
		super();
		this.mobile = mobile;
		this.amount = amount;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
