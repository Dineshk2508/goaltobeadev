package com.htc.io.outputstream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {
	public static void main(String[] args) {
		File file=new File("outfile.txt");
		FileOutputStream fileOutputStream=null;
		BufferedOutputStream bufferedOutputStream=null;
		try {
			fileOutputStream=new FileOutputStream(file);
			bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
			bufferedOutputStream.write("This is an example of writing data to a file".getBytes());
			bufferedOutputStream.write(" using BufferedOutputStream".getBytes());
			bufferedOutputStream.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fileOutputStream!=null){
					fileOutputStream.close();
				}
				if(bufferedOutputStream!=null){
					bufferedOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}