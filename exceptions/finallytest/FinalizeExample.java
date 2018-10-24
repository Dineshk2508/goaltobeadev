package com.htc.exceptions.finallytest;

public class FinalizeExample {
	@Override
	public void finalize() {
		System.out.println("finalize called");
	}

	public static void main(String[] args) {
		FinalizeExample f1 = new FinalizeExample();
		FinalizeExample f2 = new FinalizeExample();
		
		// value of objects f1 and f2 will be null		
		f1 = null;
		f2 = null;
		
		System.gc(); // finalize method will be invoked 
	}
}
