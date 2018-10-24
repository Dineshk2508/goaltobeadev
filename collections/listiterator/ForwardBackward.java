package com.htc.collections.listiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

//ListItertor interface helps to travarese forward and backward direction in list.
public class ForwardBackward {
	public static void main(String args[]) {

		ArrayList<String> al = new ArrayList<String>();

		al.add("Amit");
		al.add("Vijay");
		al.add("Kumar");
		al.add(1, "Sachin");

		System.out.println("element at 2nd position: " + al.get(2));

		ListIterator<String> itr = al.listIterator(); // Defining the listitertor

		System.out.println("traversing elements in forward direction...");

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("traversing elements in backward direction...");

		while (itr.hasPrevious()) {
			System.out.println(itr.previous());
		}
	}
}
