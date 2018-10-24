package com.htc.exceptions.throwkeyword;

//method which throw unchecked Exception doesnt need throws keyword.
public class TestThrow1 {
	static void validate(int age) {
		if (age < 18)
			// 100/0;
			throw new ArithmeticException("not valid");
		else
			System.out.println("welcome to vote");
	}

	public static void main(String args[]) {
		try {
			validate(19);
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		System.out.println("rest of the code...");
	}
}
