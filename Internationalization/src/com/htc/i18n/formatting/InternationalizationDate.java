package com.htc.i18n.formatting;

//displaying the date according to the different locale such as UK, US, FRANCE etc
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class InternationalizationDate {

	static void printDate(Locale locale) {
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL, locale);
		Date currentDate = new Date();
		String date = formatter.format(currentDate);
		System.out.println(date + " " + locale);
	}

	public static void main(String[] args) {
		printDate(new Locale("tam","IN"));
		printDate(Locale.UK);
		printDate(Locale.US);
		printDate(Locale.FRANCE);
		printDate(Locale.GERMAN);
		printDate(Locale.JAPAN);
	}
}