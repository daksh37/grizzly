package com.cts.grizzlystoreadminweb.bean;

public class Category {
	private String categoryid;
	private String name;
	private static Category category;
	public static Category getInstance(){
		if(category  == null){
			category = new Category();
			return category; 
		}
		else 
			return category;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category(String categoryid, String name) {
		super();
		this.categoryid = categoryid;
		this.name = name;
	}
	public Category() {

		// TODO Auto-generated constructor stub
	}
	
}
