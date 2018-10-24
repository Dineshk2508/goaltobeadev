package com.htc.collections.comparator;

import java.util.ArrayList;
import java.util.Collections;

import com.htc.collections.comparable.Employee;

public class EmployeeComparatorMain {
	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(123, "Gopi", 25, 1000.00, 3));
		employees.add(new Employee(100, "Ashok", 29, 63516.00, 2));
		employees.add(new Employee(125, "John", 45, 54541.00, 5));
		employees.add(new Employee(302, "Darwin", 35, 2315.00, 1));

		//Collections.sort(employees,new EmpNameComparator());
		//Collections.sort(employees,new EmpAgeComparator());
		//Collections.sort(employees,new EmpSalaryComparator());
		Collections.sort(employees,new EmpExpComparator());
		Collections.reverse(employees);
		
		for(Employee emp:employees)
			System.out.println(emp);
	}

}
