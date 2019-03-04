package com.cts.grizzlystoreadminweb.service;

import com.cts.grizzlystoreadminweb.bean.Category;

public interface AddCategoryService {
	public String getCategoryName();
	public String getCategory();
	public String insertCategory(Category category);
}
