package com.htc.collections.legacy;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
		
		// vector object with default constructor will create a vector array with the size of 10 
		// parameterized constructor will take initialCapacity and  capacityIncrement as a parameter
		Vector<Integer> vector=new Vector<>();
		
		vector.add(1);  // collection  
		vector.addElement(30);  // vector
		vector.add(1, 54);  //collection
		
		// size of the dynamic array created inside the vector
		
		System.out.println("Vector Capacity: "+vector.capacity());
		/*for(Integer i:vector)
			System.out.println(i);*/
		
		// retriving vector elements using index
		System.out.println("Element at index 2:"+vector.elementAt(2));
		
		// method to increase or decrease the vector size.
		vector.setSize(20);
		
		// vector elements as an enumeration
		Enumeration<Integer> vectorElements=vector.elements();
		while(vectorElements.hasMoreElements()) 
			
		System.out.println(vectorElements.nextElement());
		
		System.out.println("Vector is Empty: "+vector.isEmpty());
		System.out.println("Executing Vector.clear()");
		// removes all elements from the vector.
		vector.clear();
		System.out.println("Vector is Empty: "+vector.isEmpty());
		
		
		
	}
}
