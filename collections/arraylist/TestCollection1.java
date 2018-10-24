package com.htc.collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

//iterating using Iterator Interface.
class TestCollection1 {
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();// Creating arraylist
		list.add("Ravi");// Adding object in arraylist
		list.add("Vijay");
		list.add("Ravi");
		list.add("Ajay");
		list.add("John");
		/*
		// Traversing list through Iterator
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}*/
		
		// for Set
		LinkedHashSet<String> setOfNames=new LinkedHashSet<>();
		setOfNames.add("John");
		setOfNames.add("Charles");
		setOfNames.add("John");
		setOfNames.add("Ravi");
		System.out.println(Collections.frequency(list,"Ravi"));
		/*for( String name:setOfNames) {
			System.out.println(name);
		}*/
		
	}
}