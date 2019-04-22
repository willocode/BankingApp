package com.revature.beans;

import java.util.Arrays;

public class Reimbursement {
	
	private int id;
	private double amount;
	private byte[] img;
	private String details;
	private int pending;
	private int resolved;
	private int approved;
	private int denied;
	private int employeeid;
	private Employee employee;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int id, double amount, byte[] img, String details, int pending, int resolved, int approved,
			int denied, int employeeid) {
		super();
		this.id = id;
		this.amount = amount;
		this.img = img;
		this.details = details;
		this.pending = pending;
		this.resolved = resolved;
		this.approved = approved;
		this.denied = denied;
		this.employeeid = employeeid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getPending() {
		return pending;
	}
	public void setPending(int pending) {
		this.pending = pending;
	}
	public int getResolved() {
		return resolved;
	}
	public void setResolved(int resolved) {
		this.resolved = resolved;
	}
	public int getApproved() {
		return approved;
	}
	public void setApproved(int approved) {
		this.approved = approved;
	}
	public int getDenied() {
		return denied;
	}
	public void setDenied(int denied) {
		this.denied = denied;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", img=" + Arrays.toString(img) + ", details="
				+ details + ", pending=" + pending + ", resolved=" + resolved + ", approved=" + approved + ", denied="
				+ denied + ", employeeid=" + employeeid + "]";
	}

	

}
