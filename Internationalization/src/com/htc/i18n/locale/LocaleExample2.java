package com.htc.i18n.locale;

import java.util.Locale;

//Let's see how english is written in french and spanish languages.


public class LocaleExample2 {
	public static void main(String[] args) {
		Locale enLocale = new Locale("en", "US");
		Locale frLocale = new Locale("fr", "FR");
		Locale esLocale = new Locale("es", "ES");
		System.out.println(Locale.getDefault());
		System.out.println("English language name (default): " + enLocale.getDisplayLanguage());

		System.out.println("English language name in French: " + enLocale.getDisplayLanguage(frLocale));
		System.out.println("English language name in spanish: " + enLocale.getDisplayLanguage(esLocale));
	}

}