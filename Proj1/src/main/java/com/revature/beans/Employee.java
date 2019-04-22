package com.revature.beans;

public class Employee {
	
	private int id;
	private String username;
	private String password;
	private String title;
	private int managerId;
	private Employee manager;//initially null

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int id, String username, String password, String title, int managerId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.title = title;
		this.managerId = managerId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getManagerId() {
		return managerId;
	}


	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}


	public Employee getManager() {
		return manager;
	}


	public void setManager(Employee manager) {
		this.manager = manager;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", Username=" + username + ", Password=" + password + ", title=" + title
				+ ", managerId=" + managerId + "]";
	}
	
	

}
