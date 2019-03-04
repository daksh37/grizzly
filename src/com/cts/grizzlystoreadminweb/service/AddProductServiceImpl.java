package com.cts.grizzlystoreadminweb.service;

import com.cts.grizzlystoreadminweb.bean.Product;
import com.cts.grizzlystoreadminweb.dao.AddProductDAO;
import com.cts.grizzlystoreadminweb.dao.AddProductDAOImpl;

public class AddProductServiceImpl implements AddProductService {
		private static AddProductServiceImpl addProductServiceImpl;
		private AddProductDAO dao = AddProductDAOImpl.getInstance();
		public static AddProductService getInstance(){
			if(addProductServiceImpl==null)
			{
				addProductServiceImpl=new AddProductServiceImpl();
				return addProductServiceImpl;
			}
			else
				return addProductServiceImpl;	
		}
		
		public String getProduct() {
			// TODO Auto-generated method stub
			return dao.getProduct();
		}
		
		public String insertProduct(Product product) {
			// TODO Auto-generated method stub
			return dao.insertProduct(product);
		}
		

}
