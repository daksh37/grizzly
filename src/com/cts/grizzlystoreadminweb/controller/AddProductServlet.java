package com.cts.grizzlystoreadminweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.grizzlystoreadminweb.bean.Product;
import com.cts.grizzlystoreadminweb.service.AddCategoryService;
import com.cts.grizzlystoreadminweb.service.AddCategoryServiceImpl;
import com.cts.grizzlystoreadminweb.service.AddProductService;
import com.cts.grizzlystoreadminweb.service.AddProductServiceImpl;

/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		AddProductService addProductService = AddProductServiceImpl.getInstance();
		AddCategoryService addCategoryService = AddCategoryServiceImpl.getInstance();
		String productid = request.getParameter("productId");
		String category = request.getParameter(addCategoryService.getCategoryName());
		String name = request.getParameter("productName");
		String description = request.getParameter("productDescription");
		float price = Float.parseFloat(request.getParameter("productPrice"));
		String brand = request.getParameter("brand");
		Product product = new Product(productid, category, name, description, price, brand);
		addProductService.insertProduct(product);
	}

}
