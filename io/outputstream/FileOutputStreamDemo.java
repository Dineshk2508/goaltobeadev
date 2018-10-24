package com.htc.io.outputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
	public static void main(String[] args) {

		FileOutputStream fop = null;
		File file;
		String content = "This is the text content from FileOutputStream";

		try {

			file = new File("FileOutputStream.txt");  // creates a file in current path
			fop = new FileOutputStream(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();    // move all waiting request to cpu
			fop.close();   // fop=null;

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}