package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Model.Login;
import com.Model.userS;
import com.Requirements.CommonRequirement;

import DatabaseConnectivity.ConnectDB;

public class CommonDao implements CommonRequirement {

	Connection con = null;
	ConnectDB conn = new ConnectDB();
	PreparedStatement pstate = null;
	ResultSet result = null;
	int accno = 121000;
	int i;
	List<Login> userlist = null;
	Login  u=null;
	public CommonDao() {
		con=conn.connect();
	}

	@Override
	public int register(userS u) {
		
		try {
			pstate=con.prepareStatement("insert into mvn_bnkuser (accno,username,email,mobNumber,password,bankBal) values (seq_1.nextval,?,?,?,?,0)");
			
			pstate.setString(1, u.getUsername());
			pstate.setString(2, u.getEmail());
			pstate.setLong(3, u.getMobNumber());
			pstate.setString(4, u.getPassword());
			
			i=pstate.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Login> userlist() {
		userlist = new ArrayList<Login>();
		
		try {
			pstate = con.prepareStatement("select * from mvn_bnkuser u");
			result= pstate.executeQuery();
			i=1;
			while(result.next()) {
				Login  u= new Login(result.getString(1), result.getString(2));
				userlist.add(u);
				System.out.println(i);
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist;
	}

	public Login finduser(String email) {
		u=new Login();
		try {
			pstate=con.prepareStatement("select u.email,u.password from mvn_bnkuser u where email=?");
			pstate.setString(1, email);
			result = pstate.executeQuery();
			while(result.next()) {
				
				u.setEmail(result.getString(1));
				u.setPass(result.getString(2));
				 return u;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	
	
}
