package com.htc.collections.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorDemo {

	public static void main(String[] args) {
		LinkedList<String> empName=new LinkedList<String>();
		empName.add("John");
		empName.add("Gopi");
		empName.add("Raj");
		empName.add("Saran");
		ListIterator<String> litr=empName.listIterator();
		
		while(litr.hasNext()) {
			if(litr.nextIndex()==3)
				litr.add("Kiran");
			System.out.print("index: "+litr.nextIndex());
			System.out.println(" "+litr.next());
			
		}
		System.out.println(litr.hasPrevious());
		System.out.println(litr.previousIndex());
		System.out.println(litr.previous());
		
		
	}
}
