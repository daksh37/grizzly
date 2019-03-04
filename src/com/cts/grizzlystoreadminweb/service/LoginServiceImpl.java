package com.cts.grizzlystoreadminweb.service;

import com.cts.grizzlystoreadminweb.bean.Login;
import com.cts.grizzlystoreadminweb.dao.LoginDAO;
import com.cts.grizzlystoreadminweb.dao.LoginDAOImpl;
import com.cts.grizzlystoreadminweb.service.LoginService;
import com.cts.grizzlystoreadminweb.service.LoginServiceImpl;

public class LoginServiceImpl implements LoginService {
	private static LoginServiceImpl loginServiceImpl;
	private LoginDAO dao = LoginDAOImpl.getInstance();
	public static LoginService getInstance() {
	 if(loginServiceImpl == null){
		 loginServiceImpl = new LoginServiceImpl();
		 return loginServiceImpl;
	 }
	 else
		 return loginServiceImpl;
	
}
	@Override
	public Login authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		return dao.authenticate(userName, password);
	}
	@Override
	public int getUserStatus(String id) {
		// TODO Auto-generated method stub
		return dao.getUserStatus(id);
	}
	@Override
	public String getUserType(String id) {
		// TODO Auto-generated method stub
		return dao.getUserType(id);
	}
	@Override
	public String authorization(String id) {
		// TODO Auto-generated method stub
		return dao.getUserType(id);
	}
}
