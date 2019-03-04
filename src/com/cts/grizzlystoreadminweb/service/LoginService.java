package com.cts.grizzlystoreadminweb.service;

import com.cts.grizzlystoreadminweb.bean.Login;

public interface LoginService {
	public Login authenticate(String userName, String password);
	public int getUserStatus(String id); 
	public String getUserType(String id);
	public String authorization ( String id);
}
