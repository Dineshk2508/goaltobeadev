package com.htc.io.inputstream;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamDemo {
	public static void main(String[] args) {
		String data="This is an example of ByteArrayInputStream";
		
		ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(data.getBytes());
		int d;
		while((d=byteArrayInputStream.read())!=-1){
			System.out.print((char)d);
		}	
	}
}