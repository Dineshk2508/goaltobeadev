package com.htc.collections.comparator;

import java.util.Comparator;

import com.htc.collections.comparable.Employee;

public class EmpSalaryComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		int result=0;
		if(emp1.getSalary()>emp2.getSalary())
			result=1;
		else if(emp1.getSalary()<emp2.getSalary())
			result=-1;
		return result;
	}
	

}
