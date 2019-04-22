package com.revature.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;

public class ReimbursementDAOI implements ReimbursementDAO {
	


	public List<Reimbursement> getReimbursements(int reimbursement) {
		return null;
	}

	
	@Override
	public List<Reimbursement> getReimbursements() {
		return null;
//		List<Reimbursement> reim = new ArrayList<>();
//		try (Connection con = ConnectionUtil.getConnectionFromFile(x)) {
//			String sql = "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEE ID = ?";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				int userId = rs.getInt("USER_ID");
//				String username = rs.getString("USERNAME");
//				int password = rs.getInt("USERPASSWORD");
//				BankUser bankUser = new BankUser(userId, username, password);
//				reim.add(bankUser);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return reim;
	}


	@Override
	public void uploadReimbursement(int id) {
		// TODO Auto-generated method stub
		
	}


}
