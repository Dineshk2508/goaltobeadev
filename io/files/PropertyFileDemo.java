package com.htc.io.files;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileDemo {

	public static void main(String[] args) {
		Properties properties=new Properties();
		try {
			properties.load(new FileInputStream("PropertyFileDemo.properties"));
			System.out.println(properties.getProperty("name"));
			System.out.println(properties.getProperty("fileType"));
			System.out.println(properties.getProperty("language"));
			properties.setProperty("topic","FileHandling");
			System.out.println(properties.getProperty("topic"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
