package com.htc.exceptions.checkedunchecked;
// exceptions that are checked at compile time. If some code within a method throws a checked exception,
// then the method must either handle the exception or it must specify the exception using throws keyword.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExample {
	 public static void main(String[] args)  {
	        FileReader file=null;
			try {
				file = new FileReader("C:\\test\\a.txt");
			} catch (FileNotFoundException e) {
				 
				e.printStackTrace();
			}
	        BufferedReader fileInput = new BufferedReader(file);
	         
	        // Print first 3 lines of file "C:\test\a.txt"
	       // uncomment the below block to understand checked exception (compile time)
	        /* for (int counter = 0; counter < 3; counter++) 
	            System.out.println(fileInput.readLine());
	         
	        fileInput.close();*/
	    }
}
