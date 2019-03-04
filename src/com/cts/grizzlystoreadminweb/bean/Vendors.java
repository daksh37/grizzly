package com.cts.grizzlystoreadminweb.bean;

public class Vendors {
	private String id;
	private String name;
	private String contactno;
	private String address;
	private static Vendors vendors;
	public static Vendors getInstance(){
		if(vendors== null){
			vendors = new Vendors();
			return vendors;
		}
		else 
			return vendors;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Vendors(String id, String name, String contactno, String address) {
		super();
		this.id = id;
		this.name = name;
		this.contactno = contactno;
		this.address = address;
	}
	public Vendors() {
		// TODO Auto-generated constructor stub
	}
	
}
