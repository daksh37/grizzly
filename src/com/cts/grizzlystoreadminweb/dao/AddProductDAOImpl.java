package com.cts.grizzlystoreadminweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.grizzlystoreadminweb.bean.Product;
import com.cts.grizzlystoreadminweb.util.DBUtils;

public class AddProductDAOImpl implements AddProductDAO{
	private static AddProductDAOImpl addProductDAOImpl;
	public static AddProductDAOImpl getInstance(){
		if(addProductDAOImpl == null){
			addProductDAOImpl = new AddProductDAOImpl();
			return addProductDAOImpl;
		}
		else 
			return addProductDAOImpl;
	}
		
	
	public String insertProduct(Product product){
		String query = "insert into product values(?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, product.getProductid());
			preparedStatement.setString(2, product.getCategory());
			preparedStatement.setString(3, product.getName());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setFloat(5, product.getPrice());
			preparedStatement.setString(6, product.getBrand());
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
	
	public String getProduct() {
		// TODO Auto-generated method stub\
		String query = "select * from product";
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
	
}
