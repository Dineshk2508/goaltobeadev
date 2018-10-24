package com.htc.i18n.formatting;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MsgFormat {

	public static void main(String[] args) {

		ResourceBundle resource = ResourceBundle.getBundle("ApplicationResources");
		System.out.println("Default Locale: " + Locale.getDefault());
		String formattedMsg = MessageFormat.format(resource.getString("climateMsg"), "Chennai", "Cloudful", "High", "Light");
		System.out.println(formattedMsg);
	}

}