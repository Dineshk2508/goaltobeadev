package com.htc.io.externalize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
 
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream("Employee.txt"));
					
		obj.writeObject(new Employee(123,"Gopi",new Address(123,"street","city")));
		
		obj.close();
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Employee.txt"));
		try {
			System.out.println((Employee)ois.readObject());
			ois.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
