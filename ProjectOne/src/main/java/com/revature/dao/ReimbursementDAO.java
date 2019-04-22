package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;


public interface ReimbursementDAO {

	public List<Reimbursement> getReimbursements();
	
	public void uploadReimbursement(int id);

	
}

