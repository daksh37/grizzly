package com.cts.grizzlystoreadminweb.service;

import com.cts.grizzlystoreadminweb.bean.Category;
import com.cts.grizzlystoreadminweb.dao.AddCategoryDAO;
import com.cts.grizzlystoreadminweb.dao.AddCategoryDAOImpl;;

public class AddCategoryServiceImpl implements AddCategoryService{
		private static AddCategoryServiceImpl addCategoryServiceImpl;
		private AddCategoryDAO dao = AddCategoryDAOImpl.getInstance();
		public static AddCategoryService getInstance(){
			if(addCategoryServiceImpl == null){
				addCategoryServiceImpl = new AddCategoryServiceImpl();
				return addCategoryServiceImpl;
			}
			else
				return addCategoryServiceImpl;
		}
		
		public String getCategoryName(){
			return dao.getCategoryName();
		}
		public String getCategory(){
			return dao.getCategory();
		}
		public String insertCategory(Category category){
			return dao.insertCategory(category);
			
		}
}
