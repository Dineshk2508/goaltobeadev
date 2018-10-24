package com.htc.collections.map;
//Java Map Example: Non-Generic (Old Style)

import java.util.*;

public class MapExample1 {
	public static void main(String[] args) {
		Map<Integer, String> names = new HashMap<Integer, String>();

		// Adding elements to map
		names.put(new Integer(1), "Amit");
		names.put(5, "Rahul");
		names.put(2, "Jai");
		names.put(6, "Amit");

		// Traversing Map
		// Set<Map.Entry<Integer, String>>
		Set<Map.Entry<Integer, String>> set = names.entrySet(); // Converting to Set so that we can traverse

		
		for(Map.Entry name:set) {
			System.out.println(names.get(name.getKey()));
			//System.out.println(name.getValue());
		}
		/*Iterator itr = set.iterator();
		
		while (itr.hasNext()) {
			// Converting to Map.Entry so that we can get key and value separately
			Map.Entry entry = (Map.Entry) itr.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}*/
		
		
		
		
		
		
	}
}
