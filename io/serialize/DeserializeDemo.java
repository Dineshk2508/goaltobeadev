package com.htc.io.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;



public class DeserializeDemo {

	public static void main(String[] args) {
		
		try {
			ObjectInputStream ois = 
					new ObjectInputStream(new FileInputStream("SerializedEmployees.txt"));
			Employee emp = (Employee) ois.readObject();
			System.out.println(emp);
			ois.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
}
