package com.htc.io.files;

import java.io.File;
import java.util.Date;

public class FileAndDirectoryFunctions {

	public static void main(String[] args) {
		String directoryPath = "D:/fileHandling/";
		String fileName = "FileDemo.txt";
		File directory = new File(directoryPath);
		File file = new File(directoryPath + fileName);
		
		System.out.println("Directory functions");
		System.out.println("Exist: "+directory.exists());
		System.out.println("isDirecotry: "+directory.isDirectory());
		System.out.println("Directory Path: "+directory.getAbsolutePath());
		System.out.println("Parent directory name: " +directory.getParent());
		System.out.println("isHidden: "+directory.isHidden());
		System.out.println("Last modified date: "+new Date(directory.lastModified()));
		System.out.println("List of file names inside the directory");
		for(String name: directory.list()) {
			System.out.println(name);
		}
			
		System.out.println();
		System.out.println("File Funtions");
		System.out.println("can Execute: "+file.canExecute());
		System.out.println("can Read: "+file.canRead());
		System.out.println("can write: "+file.canWrite());
		System.out.println("file path: " +file.getAbsolutePath());
		System.out.println("is file: "+file.isFile());
		System.out.println("is hidden: "+file.isHidden());
		System.out.println("last modified date: "+ new Date(file.lastModified()));
		
		file.setReadOnly();
		

	}

}
