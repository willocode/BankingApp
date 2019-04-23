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

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	private ServletContext context;

	public ReimbursementDAOImpl(ServletContext context) {
        this.context = context;
    }
	
	

	
	public void newReimbursement(Reimbursement reimburse) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection(context);
			String sql = "INSERT INTO " + 
						 "REIMBURSEMENT(AMOUNT, DETAILS, EMPLOYEEID) " + 
						 "VALUES(?, ?, ?) ";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setDouble(1, reimburse.getAmount());
			ps.setString(2, reimburse.getDetails());
			ps.setInt(3, reimburse.getEmployeeid());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				tryToClose(con);
			}
		}
	}
	
	public void tryToClose(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> getReimbursement() {
		try {
			Connection con = ConnectionUtil.getConnection(context);
			String sql = "SELECT employee.id, employee.username, reimbursement.amount, reimbursement.details, reimbursement.pending, reimbursement.approved, reimbursement.denied, reimbursement.id as rid " + 
					"FROM reimbursement " + 
					"INNER JOIN employee ON reimbursement.employeeid = employee.id ";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursement> re = new ArrayList<Reimbursement>();
			while(rs.next()) {
				re.add(parseReimbursement(rs));
			}
			con.close();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	private Reimbursement parseReimbursement(ResultSet rs) throws SQLException {
		Employee em = new Employee();
		Reimbursement reim = new Reimbursement();
		reim.setEmployee(em);
		em.setId(Integer.parseInt(rs.getString("ID"))); //you can either parse, or put getInt like getDouble below
		em.setUsername(rs.getString("USERNAME"));
		reim.setAmount(rs.getDouble("AMOUNT"));
		reim.setDetails(rs.getString("DETAILS"));
		reim.setPending(rs.getInt("PENDING"));
		reim.setApproved(rs.getInt("APPROVED"));
		reim.setDenied(rs.getInt("DENIED"));
		reim.setId(rs.getInt("RID"));
		return reim;	
	}

	@Override
	public List<Reimbursement> getByEmployeeId(int id) {
		try {
			Connection con = ConnectionUtil.getConnection(context);
			String sql = "SELECT employee.id, employee.username, reimbursement.amount, reimbursement.details, reimbursement.pending, reimbursement.approved, reimbursement.denied, reimbursement.id as rid " + 
					"FROM reimbursement " + 
					"INNER JOIN employee ON reimbursement.employeeid = employee.id "+
					"WHERE employee.id = ?";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursement> re = new ArrayList<Reimbursement>();
			while(rs.next()) {
				re.add(parseReimbursement(rs));
			}
			con.close();
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	}




	@Override
	public void updateReimbursement(Reimbursement reim) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection(context);
			String sql = "UPDATE REIMBURSEMENT " + 
						 "SET PENDING = ?, APPROVED = ?, DENIED = ? " + 
						 "WHERE ID = ? ";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setInt(1, reim.getPending());
			ps.setInt(2, reim.getApproved());
			ps.setInt(3, reim.getDenied());
			ps.setInt(4, reim.getId());
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
