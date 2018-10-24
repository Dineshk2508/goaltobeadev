package com.htc.collections.comparator;

import java.util.Comparator;

import com.htc.collections.comparable.Employee;

public class EmpExpComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getExperience()-emp2.getExperience();
	}
	

}
