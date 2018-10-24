package com.htc.collections.treeset;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetSample {
	public static void main(String args[]){  
		 // Create a TreeSet and inserting elements 
        SortedSet<String> languages = new TreeSet<>();
        
        languages.add("C"); 
        languages.add("C++"); 
        languages.add("VB"); 
        languages.add("Java"); 
  
        System.out.println("Sorted Set: " + languages); 
        System.out.println("First: " + languages.first()); 
        System.out.println("Last: " + languages.last()); 
  
        // Getting elements before VB (Excluding) in a sortedSet 
        SortedSet<String> beforeVB = languages.headSet("VB"); 
        System.out.println("Before VB: "+beforeVB); 
  
        // Getting elements between C++ (Including) and  
        // Java (Excluding) 
        SortedSet<String> betweenCAndJava = 
        		languages.subSet("C++","Java"); 
        System.out.println("Between C++ and Java: "+betweenCAndJava); 
  
        // Getting elements after c++ (Including) 
        SortedSet<String> afterC = languages.tailSet("C++"); 
        System.out.println("After C++:"+afterC);  
		
		 }  
}
