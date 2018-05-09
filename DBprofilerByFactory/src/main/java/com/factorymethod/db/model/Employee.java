package com.factorymethod.db.model;

public class Employee {
	
	private int id;
	private String userName;
	private String txtAddress;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getTxtAddress() {
		return txtAddress;
	}
	
	public void setTxtAddress(String txtAddress) {
		this.txtAddress = txtAddress;
	}

	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", txtAddress=" + txtAddress + "]";
	}
	
	

}
