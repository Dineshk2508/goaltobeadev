package com.htc.i18n.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

	public static void main(String[] args) {
		
			
		System.out.println(Locale.getDefault());
		ResourceBundle bundle=ResourceBundle.getBundle("ApplicationResources");
		StringBuilder text=new StringBuilder();
		text.append(bundle.getString("good"));
		text.append(" ");
		text.append(bundle.getString("afternoon"));
		text.append(" ");
		text.append(bundle.getString("team"));
		System.out.println(text);
		
		System.out.print(bundle.getString("male"));
		System.out.println(" "+bundle.getString("gopi"));
		
		
	}
}
