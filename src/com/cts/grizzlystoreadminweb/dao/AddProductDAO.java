package com.cts.grizzlystoreadminweb.dao;

import com.cts.grizzlystoreadminweb.bean.Product;

public interface AddProductDAO {
	public String getProduct();
	public String insertProduct(Product product);
}
