package com.Requirements;


import java.util.List;

import com.Model.transaction;
import com.Model.userS;

public interface userRequirement {

	userS userdetail(String email);
	int transaction(transaction trn);
	int mobileRecharge();
	List<transaction> trnhistory(int accno);
}
