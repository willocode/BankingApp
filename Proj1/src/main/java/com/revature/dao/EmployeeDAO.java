package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {

	public Employee getEmployeeById(int id);
	
	public List<Employee> getEmployees();
	
	public void viewInfo(int id);
	
	public Employee getByUsername(String username);
	
	

}
