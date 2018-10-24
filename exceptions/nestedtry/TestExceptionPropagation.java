package com.htc.exceptions.nestedtry;

//By default Unchecked Exceptions are forwarded in calling chain (propagated).
public class TestExceptionPropagation {
	void method1() {
		int data = 50 / 0;
	}

	void method2() {
		method1(); // method invocation
	}

	void finalMethod() {
		try {
			method2();
		} catch (Exception e) {
			System.out.println("exception handled");
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		TestExceptionPropagation obj = new TestExceptionPropagation();
		obj.finalMethod();
		System.out.println("normal flow...");
	}
}
