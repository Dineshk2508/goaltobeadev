package com.htc.exceptions.throwskeyword;

import java.io.IOException;

class Testthrows1 {
	void method1() throws IOException {
		throw new IOException("device error");// checked exception
	}

	void method2() throws IOException {
		method1();
	}

	void method3() {
		try {
			method2();
		} catch (Exception e) {
			System.out.println("exception handled");
		}
	}

	public static void main(String args[]) {
		Testthrows1 obj = new Testthrows1();
		obj.method3();
		System.out.println("normal flow...");
	}
}