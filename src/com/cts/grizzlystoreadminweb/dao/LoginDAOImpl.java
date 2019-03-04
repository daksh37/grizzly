package com.cts.grizzlystoreadminweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.grizzlystoreadminweb.bean.Login;
import com.cts.grizzlystoreadminweb.util.DBUtils;

public class LoginDAOImpl implements LoginDAO {
	private static LoginDAOImpl loginDAOImpl;
	public static  LoginDAOImpl getInstance() {
		if(loginDAOImpl == null){
			loginDAOImpl = new LoginDAOImpl();
			return loginDAOImpl;
		}
		else 
			return loginDAOImpl;
	}

	@Override
	public Login authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		String query = " select * from glogin where userid = ? and password = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				String userId= resultSet.getString(1);
				String pwd= resultSet.getString(2);
				String userType= resultSet.getString(3);
				int	userStatus= resultSet.getInt(4);
				String address= resultSet.getString(5);
				String name= resultSet.getString(6);
				String designation= resultSet.getString(7);
				int id= resultSet.getInt(8);
				String contactno= resultSet.getString(9);
				Login login = new Login(userId, pwd, userType, userStatus, address, name, designation, id, contactno);
				return login;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getUserStatus(String id) {
		// TODO Auto-generated method stub
		String query = "select userstatus from glogin where userid=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getInt("userstatus");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public String getUserType(String id) {
		// TODO Auto-generated method stub
		String query = "select usertype from glogin where userid=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getString("usertype");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
