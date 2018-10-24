
package com.htc.collections.linkedhashset;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetSample {
	public static void main(String args[])
	{
	LinkedHashSet<String> obj = new LinkedHashSet<String>();

	obj.add("Ravi");  
	obj.add("Vijay");  
	obj.add("Ravi");  
	obj.add("Ajay");  
	  Iterator<String> itr=obj.iterator();  
	  while(itr.hasNext()){  
	   System.out.println(itr.next());  
	  }  
	}} 

