package com.htc.collections.generic;

public class Display{

	public static <T> void displayArray(T[] arr){
		for(T t: arr){
			System.out.print(t+" ");
		}
	}
	public static <T extends Comparable<T>> T minimum(T obj1,T obj2){
		T result=obj1;
		
		if(obj1.compareTo(obj2)>0)
			result=obj2;
		return result;
	}
	public static void main(String[] ar){
		Integer[] inArray={1,2,3,4,5,6,7};
		Character[] charArray={'j','A','V','A'};
		String[]  stringArray={"Welcome","To","Java","Generics"};
		System.out.println("Integer Array:");
		Display.displayArray(inArray);
		System.out.println("Character Array:");
		Display.displayArray(charArray);
		System.out.println("String Array:");
		Display.displayArray(stringArray);

		System.out.println("/n"+Display.minimum(new Integer(10),45));

		
	}
}
