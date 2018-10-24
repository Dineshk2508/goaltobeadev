package com.htc.i18n.formatting;

import java.text.NumberFormat;
import java.util.Locale;


public class InternalizationNumber {

	static void printNumber(Locale locale) {
		double dbl = 105000.3245;
		NumberFormat formatter = NumberFormat.getNumberInstance(locale);
		String number = formatter.format(dbl);
		System.out.println(number + " for the locale " + locale.getDisplayName());
	}

	public static void main(String[] args) {
		printNumber(new Locale("tam","IN"));
		printNumber(Locale.UK);
		printNumber(Locale.US);
		printNumber(Locale.FRANCE);
		printNumber(Locale.GERMAN);
		printNumber(Locale.JAPAN);
		
		
		
		
		
		

	}
}