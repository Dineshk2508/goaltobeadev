package com.htc.exceptions.multicatch;

public class TestMultipleCatchBlock {
	public static void main(String args[]) {
		try {
			int a[] = new int[5]; // 0,1,2,3,4
			Object obj = null;
			System.out.println(obj.toString());

			a[5] = 10;
			a[5] = 30 / 0;
		} catch (ArithmeticException e) {
			System.out.println("task1 is completed");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("task 2 completed");
		} catch (NullPointerException ne) {
			ne.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("common task completed");
		}

		System.out.println("rest of the code...");

	}
}