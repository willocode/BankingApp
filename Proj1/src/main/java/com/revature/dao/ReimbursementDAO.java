package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	
	public List<Reimbursement> getReimbursement();
	
	List<Reimbursement> getByEmployeeId(int id);
	
	public void newReimbursement(Reimbursement reimburse);


}
