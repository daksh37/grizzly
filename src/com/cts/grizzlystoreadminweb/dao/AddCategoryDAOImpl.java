package com.cts.grizzlystoreadminweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.grizzlystoreadminweb.bean.Category;
import com.cts.grizzlystoreadminweb.util.DBUtils;

public class AddCategoryDAOImpl implements AddCategoryDAO {
	private static AddCategoryDAOImpl addCategoryDAOImpl;
	public static AddCategoryDAOImpl getInstance(){
		if(addCategoryDAOImpl == null){
			addCategoryDAOImpl = new AddCategoryDAOImpl();
			return addCategoryDAOImpl;
		}
		else 
			return addCategoryDAOImpl;
	}
	
	public String getCategoryName() {
		// TODO Auto-generated method stub\
		String query = "select name from category";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getCategory() {
		// TODO Auto-generated method stub\
		String query = "select * from category";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				//return resultSet.getString();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String insertCategory(Category category){
		String query = "insert into category values(?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, category.getCategoryid());
			preparedStatement.setString(2, category.getName());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return "success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
