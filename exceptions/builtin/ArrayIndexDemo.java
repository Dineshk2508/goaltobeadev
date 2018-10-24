package com.htc.exceptions.builtin;

public class ArrayIndexDemo {

	public static void main(String[] args) {
		int[] arr=new int[5];
		
		arr[0]=1;
		arr[1]=2;
		arr[2]=2;
		arr[3]=2;
		arr[4]=2;
		
		try {
			System.out.println(arr[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("after error");
		
	}
}
