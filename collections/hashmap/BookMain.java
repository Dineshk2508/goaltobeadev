package com.htc.collections.hashmap;

import java.util.HashMap;
import java.util.Map;

public class BookMain {

	public static void main(String[] args) {
		// Creating map of Books
		Map<Integer, Book> map = new HashMap<Integer, Book>();
		// Creating Books
		Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);
		// Adding Books to map
		map.put(b1.getId(), b1);
		map.put(b2.getId(), b2);
		map.put(b3.getId(), b3);

		/*
		 * //Traversing map for(Map.Entry<Integer, Book> entry:map.entrySet()){ int
		 * key=entry.getKey(); Book b=entry.getValue();
		 * System.out.println(key+" Details: "); System.out.println(b); }
		 */

		Library library = new Library(123, map);
		Book foundBook = library.getBook(102);
		System.out.println(foundBook);

	}
}