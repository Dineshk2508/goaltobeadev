package com.htc.corejava.enums;

public class MonthsEnamMain {

	public static void main(String[] args) {
			
		for(Months m:Months.values()) {
			 System.out.println(m.name()+" : "+(m.ordinal()+1));
			 
		}

	}

}
