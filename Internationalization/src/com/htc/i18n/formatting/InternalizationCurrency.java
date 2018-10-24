package com.htc.i18n.formatting;

import java.text.NumberFormat;
import java.util.Locale;

public class InternalizationCurrency {

	static void printCurrency(Locale locale) {
		double dbl = 10500.3245;
		NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
		String currency = formatter.format(dbl);
		System.out.println(currency + " for the locale " + locale.getDisplayName());
	}

	public static void main(String[] args) {
		printCurrency(new Locale("tam","IN"));
		printCurrency(Locale.UK);
		printCurrency(Locale.US);
		printCurrency(Locale.FRANCE);
		printCurrency(Locale.GERMAN);
		printCurrency(Locale.JAPAN);
		
		
		
		
	}
}