package com.htc.io.serialize;

import java.io.Serializable;

public class Employee implements Serializable{

	private int empno;
	private String empName;
	private transient double  salary;

	public Employee() {
	}

	public Employee(int empno, String empName, double salary) {
		this.empno = empno;
		this.empName = empName;
		this.salary = salary;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Empno:");
		sb.append(empno);
		sb.append("\nEmpname:");
		sb.append(empName);
		sb.append("\nSalary:");
		sb.append(salary);
		return sb.toString();
	}

}
