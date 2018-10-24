package com.htc.collections.comparator;

import java.util.Comparator;

import com.htc.collections.comparable.Employee;

public class EmpAgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		int compareResult=0;
		
		if(emp1.getAge()>emp2.getAge())
			compareResult=1;
		else if(emp1.getAge()<emp2.getAge())
			compareResult=-1;
		return compareResult;
	}
	

}
