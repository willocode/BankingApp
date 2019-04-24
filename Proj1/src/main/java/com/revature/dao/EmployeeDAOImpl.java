package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	
    private ServletContext context;


	public EmployeeDAOImpl(ServletContext context) {
        this.context = context;
    }
	
	public void tryToClose(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	
	@Override
	public Employee getEmployeeById(int id) {
		try {
			Connection con = ConnectionUtil.getConnection(context);
			String sql = "SELECT ID, USERNAME, PASSWORD, TITLE, MANAGERID FROM EMPLOYEE WHERE ID = ? ";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Employee employee = new Employee();
			while(rs.next()) {
				employee = parseEmployee(rs);
			}
			con.close();
			return employee;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Employee> getEmployees() {
		try {
			Connection con = ConnectionUtil.getConnection(context);
			String sql = "SELECT * FROM EMPLOYEE ";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Employee> employees = new ArrayList<Employee>();
			while(rs.next()) {
				Employee currentEmployee = parseEmployee(rs);
				employees.add(currentEmployee);
				currentEmployee.setManager(getEmployeeById(currentEmployee.getManagerId()));
			}
			con.close();
			return employees;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Employee parseEmployee(ResultSet rs) throws SQLException {
		Employee employee = new Employee();
		employee.setId(Integer.parseInt(rs.getString("ID")));
		employee.setUsername(rs.getString("USERNAME"));
		employee.setPassword(rs.getString("PASSWORD"));
		employee.setTitle(rs.getString("TITLE"));
		if(rs.getString("MANAGERID") != null) {
			employee.setManagerId(Integer.parseInt(rs.getString("MANAGERID")));
		}
		return employee;
	}

	@Override
	public void viewInfo(int id) {
		// TODO Auto-generated method stub
		
	}
	
	public Employee getByUsername(String username) {
		
		try {
			Connection con = ConnectionUtil.getConnection(context);
			String sql = "SELECT ID, USERNAME, PASSWORD, TITLE, MANAGERID FROM EMPLOYEE WHERE USERNAME = ? ";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			Employee employee = null;
			while(rs.next()) {
				employee = parseEmployee(rs);
			}
			con.close();
			return employee;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}




	@Override
	public void newEmployee(Employee employee) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection(context);
			String sql = "INSERT INTO " + 
						 "EMPLOYEE(USERNAME, PASSWORD, TITLE, MANAGERID) " + 
						 "VALUES(?, ?, ?, ?) ";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, employee.getUsername());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getTitle());
			ps.setInt(4, employee.getManagerId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				tryToClose(con);
			}
		}
	}

}


//
