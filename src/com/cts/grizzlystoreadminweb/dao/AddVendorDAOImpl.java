package com.cts.grizzlystoreadminweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.grizzlystoreadminweb.bean.Vendors;
import com.cts.grizzlystoreadminweb.util.DBUtils;

public class AddVendorDAOImpl implements AddVendorDAO {
		private static AddVendorDAOImpl addVendorDAOImpl;
		public static AddVendorDAOImpl getInstance(){
			 if(addVendorDAOImpl == null){
				  addVendorDAOImpl  = new AddVendorDAOImpl();
				  return addVendorDAOImpl;
			 }
			 else
				 return addVendorDAOImpl;
		}
		
		public String insertVendros(Vendors vendors){
			String query = "insert into vendors values(?,?,?,?)";
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			connection = DBUtils.getConnection();
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, vendors.getId());
				preparedStatement.setString(2, vendors.getName());
				preparedStatement.setString(3, vendors.getContactno());
				preparedStatement.setString(4, vendors.getAddress());
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
		
		public String getVendors() {
			// TODO Auto-generated method stub\
			String query = "select * from vendors";
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

