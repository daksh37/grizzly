package com.cts.grizzlystoreadminweb.dao;

import com.cts.grizzlystoreadminweb.bean.Category;

public interface AddCategoryDAO {
	public String getCategoryName();
	public String getCategory();
	public String insertCategory(Category category);
}
