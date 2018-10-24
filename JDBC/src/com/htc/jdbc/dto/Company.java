package com.htc.jdbc.dto;

import java.util.ArrayList;

public class Company {

	private int companyId;
	private String companyName;
	private ArrayList<Employee> employees;
	
	public Company(int companyId, String companyName, ArrayList<Employee> employees) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.employees = employees;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + "]";
	}
	
	
}
