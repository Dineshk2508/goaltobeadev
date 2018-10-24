package com.htc.io.outputstream;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PrintWriterDemo {

	public static void main(String[] args) {
		PrintWriter pw=null;
		try{
			pw=new PrintWriter(new FileOutputStream("Employee.txt"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//EmpNo			EmpName			Salary
		pw.printf("%5d%20s%20f \n",123,"Rajan",10000.00 );
		pw.printf("%5d%20s%20f \n",123,"Rajan",10000.00 );
		pw.printf("%5d%20s%20f \n",123,"Rajan",10000.00 );
		pw.printf("%5d%20s%20f \n",123,"Rajan",10000.00 );
		pw.printf("%5d%20s%20f \n",123,"Rajan",10000.00 );
		
		
		System.out.println("file created...");
		pw.close();
	}
}
