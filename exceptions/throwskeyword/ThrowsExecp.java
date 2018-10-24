package com.htc.exceptions.throwskeyword;

//Java program to demonstrate working of throws
class ThrowsExecp {
	static void fun() throws IllegalAccessException {
		System.out.println("Inside fun(). ");
		throw new IllegalAccessException("demo");
	}

	public static void main(String args[]) {
		try {
			fun();
		} catch (IllegalAccessException e) {
			System.out.println("caught in main.");
		}
	}
}