package com.htc.io.inputstream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
	public static void main(String[] args) {
		File file = new File("outfile.txt");
		FileInputStream fileInputStream = null;
		BufferedInputStream bufferedInputStream = null;

		try {
			fileInputStream = new FileInputStream(file);
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			// Create buffer
			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
				System.out.println(new String(buffer, 0, bytesRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
				if (bufferedInputStream != null) {
					bufferedInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}