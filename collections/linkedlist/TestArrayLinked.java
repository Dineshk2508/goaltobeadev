package com.htc.collections.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//Comparing ArrayList and LinkedList.
public class TestArrayLinked {
	public static void main(String args[]){    
	     
		  List<String> al=new ArrayList<String>();//creating arraylist    
		  al.add("Ravi");//adding object in arraylist    
		  al.add("Vijay");    
		  al.add("Ravi");    
		  al.add("Ajay");    
		    
		  List<String> al2=new LinkedList<String>();//creating linkedlist    
		  al2.add("James");//adding object in linkedlist    
		  al2.add("Serena");    
		  al2.add("Swati");    
		  al2.add("Junaid");    
		  
		  long milisec=System.currentTimeMillis();
		  long start=System.nanoTime();
		  //System.out.println("Start: "+start);
		  // Array List
		  for(String str:al) {
			  System.out.println(str);
		  }
		  long end=System.nanoTime();
		  //System.out.println("end: "+end);
		  System.out.println("Array List diff="+ (end - start));
		  System.out.println();
		  
		  long lstart=System.nanoTime();
		  //System.out.println("Start: "+start);
		  
		  // Linked List
		  for(String str:al2) {
			  System.out.println(str);
		  }
		  long lend=System.nanoTime();
		  //System.out.println("end: "+lend);
		  System.out.println("Linked List diff="+ (lend - lstart));
	}    
}
