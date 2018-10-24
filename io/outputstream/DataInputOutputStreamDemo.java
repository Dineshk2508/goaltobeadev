package com.htc.io.outputstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamDemo {
	public static void main(String[] args) {
		File file = new File("file.txt");
		
		/*Write primitive data type to file*/
		FileOutputStream fileOutputStream = null;
		DataOutputStream dataOutputStream = null;
		try {
			fileOutputStream=new FileOutputStream(file);
			dataOutputStream=new DataOutputStream(fileOutputStream);
			dataOutputStream.writeInt(50);
			dataOutputStream.writeDouble(400.25);
			dataOutputStream.writeChar('A');
			
			dataOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fileOutputStream!=null){
					fileOutputStream.close();
				}
				if(dataOutputStream!=null){
					dataOutputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		/*Read primitive data type from file*/
		FileInputStream fileInputStream = null;
		DataInputStream dataInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			dataInputStream = new DataInputStream(fileInputStream);
			System.out.println(dataInputStream.readInt());
			System.out.println(dataInputStream.readDouble());
			System.out.println(dataInputStream.readChar());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fileInputStream!=null){
					fileInputStream.close();
				}
				if(dataInputStream!=null){
					dataInputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}