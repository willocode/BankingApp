package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOI implements EmployeeDAO{

	@Override
	public void getEmployeeById(int id) {
		
		
	}

	@Override
	public List<Employee> getEmployees() {
		
		return null;
	}

	@Override
	public void viewInfo(int id) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getUserByLogin(String username, int password) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT USERNAME, USERPASSWORD FROM EMPLOYEE ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
