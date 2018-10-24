package com.htc.collections.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Library {

	private int libraryId;
	private Map<Integer,Book> books=new HashMap<Integer,Book>();
	
	public Library(int libraryId, Map<Integer, Book> books) {
		super();
		this.libraryId = libraryId;
		this.books = books;
	}
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}
	public Map<Integer, Book> getBooks() {
		return books;
	}
	public void setBooks(Map<Integer, Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Library [libraryId=" + libraryId + ", books=" + books + "]";
	}
	public Book getBook(int bookId) {
	
		return this.books.get(bookId);
		/*
		Book foundBook=null;
		for(Map.Entry<Integer, Book> book:this.books.entrySet()) {
			if(book.getValue().getId()==bookId) {
				foundBook=book.getValue();
				break;
			}
		}
		return foundBook;*/
	}
	
	
}
