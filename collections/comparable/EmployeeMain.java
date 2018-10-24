package com.htc.collections.comparable;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeeMain {
	public static void main(String[] args) {

		ArrayList<Employee> employees=new ArrayList<Employee>();
		employees.add(new Employee(123,"Gopi",25,1000.00,3));
		employees.add(new Employee(100,"Ashok",29,63516.00,2));
		employees.add(new Employee(125,"John",45,54541.00,5));
		employees.add(new Employee(302,"Darwin",35,2315.00,1));
		
		Collections.sort(employees);
		
		for(Employee emp:employees)
		System.out.println(emp);
	}
}
