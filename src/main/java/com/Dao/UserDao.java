package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Model.transaction;
import com.Model.userS;
import com.Requirements.userRequirement;

import DatabaseConnectivity.ConnectDB;

public class UserDao implements userRequirement {
	
	Connection con=null;
	ConnectDB conn=new ConnectDB();
	PreparedStatement pstate = null;
	userS u = null;
	ResultSet res= null;
	int i = 0;
	int k=0;
	public UserDao(){
		con = conn.connect();
	}

	@Override
	public userS userdetail(String email) {
		
		try {
			pstate= con.prepareStatement("select * from mvn_bnkuser where email=?");
			pstate.setString(1, email);
			
			res = pstate.executeQuery();
			if(res.next()) {
				u= new userS(res.getInt(1),res.getString(2), res.getString(3),res.getLong(4), res.getString(5),res.getFloat(6));
				return u;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public int transaction (transaction trn) {
		// int p=0;
		try {
			
			pstate= con.prepareStatement("insert into mvn_bnktran (id,accno,tranby,ifsc,accHolder,amount,trndate,trtype) values (seq_tran.nextval,?,?,?,?,?,CURRENT_DATE,?)");
			pstate.setInt(1, trn.getAccno());
			pstate.setInt(2, trn.getTransby());
			pstate.setInt(3, trn.getIfsc());
			pstate.setString(4, trn.getAccHolder());
			pstate.setFloat(5, trn.getAmt());
			pstate.setString(6, trn.getTrtype());
			i = pstate.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return i;
	}
	
	public int addBal(int accno, float amt) {
		try {
			pstate=con.prepareStatement("update mvn_bnkuser set BANKBAL=BANKBAL+? where accno=?");
			pstate.setFloat(1, amt);
			pstate.setInt(2, accno);
			k= pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return k;
	}
	
	public int updateuserinfo(int accno, userS u) {
		int i=0;
		try {
			pstate=con.prepareStatement("update mvn_bnkuser set username=?, mobnumber=?, EMAIL=?, PASSWORD=? where accno=?");
			pstate.setString(1, u.getUsername());
			pstate.setLong(2, u.getMobNumber());
			pstate.setString(3, u.getEmail());
			pstate.setString(4, u.getPassword());
			pstate.setInt(5, accno);
			i= pstate.executeUpdate();
			
			if(i>0){
				System.out.println("User Detail Updated.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public int deductBal(int accno, float amt) {
		
		try {
			
			pstate=con.prepareStatement("update mvn_bnkuser set BANKBAL=BANKBAL-? where accno=?");
			pstate.setFloat(1, amt);
			pstate.setInt(2, accno);
			k= pstate.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return k;
	}
	
	@Override
	public List<transaction> trnhistory(int accno) {
		List<transaction> trn = new ArrayList<transaction>();
		try {
			pstate=con.prepareStatement("select tranby,ifsc,accHolder,AMOUNT, trtype,trndate from mvn_bnktran where accno=?");
			pstate.setInt(1, accno);
			res = pstate.executeQuery();
			while (res.next()) {
				transaction t = new transaction(res.getInt(1), res.getInt(2), res.getString(3), res.getInt(4), res.getString(5),res.getDate(6));
				trn.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trn;
	}

	@Override
	public int mobileRecharge() {
		return 0;
	}

}
