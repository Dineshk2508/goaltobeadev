package com.htc.collections.comparable;

public class Employee implements Comparable<Employee> {

	private int empId;
	private String name;
	private int age;
	private double salary;
	private int experience;

	public Employee(int empId, String name, int age, double salary, int experience) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.experience = experience;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", salary=" + salary + ", experience="
				+ experience + "]";
	}

	@Override
	public int compareTo(Employee emp) {
		int compareResult = 0;
		if (this.empId > emp.getEmpId())
			compareResult = 1;
		else if (this.empId < emp.getEmpId())
			compareResult = -1;

		return compareResult;
		
		//return new Integer(this.empId).compareTo(emp.getEmpId());
		
		//return this.empId-emp.getEmpId();
		
		
	}

}
