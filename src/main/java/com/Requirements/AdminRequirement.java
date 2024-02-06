package com.Requirements;

import java.util.List;

import com.Model.userS;

public interface AdminRequirement {
	
	List<userS> searchuser(String email);
	List<userS> allusers();
	int deleteuser(String email);
}
