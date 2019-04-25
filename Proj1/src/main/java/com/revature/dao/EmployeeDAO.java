package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;

public interface EmployeeDAO {

	public Employee getEmployeeById(int id);
	
	public List<Employee> getEmployees();
	
	public void viewInfo(int id);
	
	public Employee getByUsername(String username);
	
	public void newEmployee(Employee employee);
	
	public void updateEmployee(Employee emp);

	
	

}
