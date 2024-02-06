package com.Model;

import java.sql.Date;

public class transaction {
	
	private int accno;
	private int transby;
	private int ifsc;
	private String accHolder;
	private int amt;
	private String trtype;
	private Date trndate ;
	
	public transaction() {
		
	}

	
	
	
	public transaction(int accno, int transby, int ifsc, String accHolder, int amt, String trtype, Date trndate) {
		super();
		this.accno = accno;
		this.transby = transby;
		this.ifsc = ifsc;
		this.accHolder = accHolder;
		this.amt = amt;
		this.trtype = trtype;
		this.trndate = trndate;
	}

	public transaction( int transby, int ifsc, String accHolder, int amt, String trtype, Date trndate) {
		
		this.transby = transby;
		this.ifsc = ifsc;
		this.accHolder = accHolder;
		this.trtype = trtype;
		this.amt = amt;
		this.trndate = trndate;
	}



	public String getTrtype() {
		return trtype;
	}




	public void setTrtype(String trtype) {
		this.trtype = trtype;
	}




	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public int getTransby() {
		return transby;
	}

	public void setTransby(int transby) {
		this.transby = transby;
	}

	public int getIfsc() {
		return ifsc;
	}

	public void setIfsc(int ifsc) {
		this.ifsc = ifsc;
	}

	public String getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public Date getTrndate() {
		return trndate;
	}

	public void setTrndate(Date trndate) {
		this.trndate = trndate;
	}
	


	
	
 }
