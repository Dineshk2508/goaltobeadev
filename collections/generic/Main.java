package com.htc.collections.generic;

import com.htc.object.clone.Employee;

public class Main {

	public static void main(String[] args) {

		// Array<Object> obj=new Array<Object>();
		// it will create RunTime error based on the dynamic parameters

		GenericArray<Integer> integ = new GenericArray<Integer>(Integer[].class);

		System.out.println("Type: " + Integer[].class.getComponentType());

		integ.setValue(new Integer(123));
		integ.setValue(new Integer(124));
		integ.setValue(125);
		integ.setValue(126);
		integ.setValue(127);

		for (int i = 0; i < integ.length(); i++) {
			System.out.println(integ.getValue(i));
		}

	}

}
