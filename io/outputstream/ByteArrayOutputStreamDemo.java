package com.htc.io.outputstream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		String string1 = "This is an example ";
		String string2 = "of ByteArrayInputStreamExample";

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byteArrayOutputStream.write(string1.getBytes());
		byteArrayOutputStream.write(string2.getBytes());

		System.out.println("Output data : " + byteArrayOutputStream.toString());
	}
}