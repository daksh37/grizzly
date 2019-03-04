package com.cts.grizzlystoreadminweb.dao;

import com.cts.grizzlystoreadminweb.bean.Login;

public interface LoginDAO {
	public int getUserStatus(String id); 
	public String getUserType(String id);
	public Login authenticate(String userName, String password);
}
