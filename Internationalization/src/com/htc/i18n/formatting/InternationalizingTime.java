package com.htc.i18n.formatting;

//displaying the current time for the specified locale. 
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class InternationalizingTime {

	static void printTime(Locale locale) {
		
		DateFormat formatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
		Date currentDate = new Date();
		String time = formatter.format(currentDate);
		System.out.println(time + " in locale " + locale);
	}

	public static void main(String[] args) {
		printTime(new Locale("tam","IN"));
		printTime(Locale.UK);
		printTime(Locale.US);
		printTime(Locale.FRANCE);
		printTime(Locale.GERMAN);
		printTime(Locale.JAPAN);
	}
}