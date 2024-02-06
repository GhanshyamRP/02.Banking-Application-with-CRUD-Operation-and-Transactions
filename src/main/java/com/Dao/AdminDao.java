package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.Model.userS;
import com.Requirements.AdminRequirement;

import DatabaseConnectivity.ConnectDB;

public class AdminDao implements AdminRequirement {

	Connection con=null;
	ConnectDB conn = new ConnectDB();
	PreparedStatement pstate=null;
	Statement cstate= null;
	int i=0;
	ResultSet res = null;
	userS u ;
	List<userS> ul = null;
	public AdminDao() {
		con = conn.connect();
	}

	@Override
	public List<userS> searchuser(String email) {
	ul= new ArrayList<userS>();
		try {
			pstate=con.prepareStatement("Select * from mvn_bnkuser where email=?");
			pstate.setString(1, email);
			res = pstate.executeQuery();
			
			while(res.next()) {
				u= new userS(res.getInt(1),res.getString(2), res.getString(3),res.getLong(4), res.getString(5),res.getFloat(6));
				ul.add(u);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ul;
	}

	@Override
	public List<userS> allusers() {
		ul= new ArrayList<userS>();
		try {
			pstate=con.prepareStatement("Select * from mvn_bnkuser ");
			res = pstate.executeQuery();
			while(res.next()) {
				u= new userS(res.getInt(1),res.getString(2), res.getString(3),res.getLong(4), res.getString(5),res.getFloat(6));
				ul.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ul;
	}

	@Override
	public int deleteuser(String email) {
		try {
			pstate=con.prepareStatement("Delete mvn_bnkuser where email=?");
			pstate.setString(1, email);
			i = pstate.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return i;
	}

}
