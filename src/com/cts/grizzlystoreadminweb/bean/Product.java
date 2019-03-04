package com.cts.grizzlystoreadminweb.bean;


public class Product {
	private String productid;
	private String category;
	private String name;
	private String description;
	private float price;
	private String brand;
	private static Product product;
	public static Product getInstance(){
		if(product == null){
			product = new Product();
			return product;
		}
		else 
			return product;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public Product(String productid, String category, String name, String description, float price, String brand) {
		super();
		this.productid = productid;
		this.category = category;
		this.name = name;
		this.description = description;
		this.price = price;
		this.brand = brand;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	

}
