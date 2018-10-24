package com.htc.collections.treemap;

import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapSample {
	public static void main(String args[]){  
		  TreeMap<Integer,String> hm=new TreeMap<Integer,String>();  
		  hm.put(102,"Ravi");  
		  hm.put(100,"Amit");  
		  
		  hm.put(101,"Vijay");  
		  hm.put(103,"Rahul");  
		  for(Entry<Integer, String> m:hm.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		  }  
}
}