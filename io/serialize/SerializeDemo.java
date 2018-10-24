package com.htc.io.serialize;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.htc.io.serialize.Employee;

public class SerializeDemo {

	public static void main(String[] args) {

		Employee emp = new Employee(101, "Charles", 50000.0);

		try {

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerializedEmployees.txt"));
			oos.writeObject(emp);
			
			oos.close();
			System.out.println("Object Serialized");

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}
