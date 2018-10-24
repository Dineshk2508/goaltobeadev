package com.htc.io.files;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) throws IOException {

		String directoryPath = "D:/fileHandling/";
		String fileName = "FileDemo.txt";
		File directory = new File(directoryPath);
		File fileDemo = new File(directoryPath + fileName);
		if (directory.exists()) {
			System.out.println("Directory exist");
			if (fileDemo.exists())
				System.out.println("The file exist");
			else {
				System.out.println("The file doesn't exist");
				System.out.println("Creating new file: " + fileDemo.createNewFile());

			}
		} else {
			System.out.println("The specified Directory(ies) doesn't exist");
			System.out.println("creating new directory: " + directory.mkdirs());
			
				System.out.println("The file doesn't exist");
				System.out.println("Creating new file: " + fileDemo.createNewFile());

			
		}

	}

}
