package com.Model;

public class userS {
	
	private int accNo;
	private String username;
	private String email;
	private long mobNumber;
	private String password;
	private float bankBal;
	
	public userS(){
	}

	public userS(int accNo,String email, String password) {
		super();
		
		this.email = email;
		this.password = password;
		
	}
	
	public userS(String email, String password,String username) {
		super();
		
		this.email = email;
		this.password = password;
		this.username = username;
		
	}
	
	public userS(int accNo, String username, String email, long mobNumber, String password, float bankBal) {
		super();
		this.accNo = accNo;
		this.username = username;
		this.email = email;
		this.mobNumber = mobNumber;
		this.password = password;
		this.bankBal = bankBal;
	}
	
	public userS( String username, String email, long mobNumber, String password) {
		super();
		this.username = username;
		this.email = email;
		this.mobNumber = mobNumber;
		this.password = password;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public long getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(int mobNumber) {
		this.mobNumber = mobNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getBankBal(){
		return bankBal;
	}

	public void setBankBal(float bankBal) {
		this.bankBal = bankBal;
	}
	
}
