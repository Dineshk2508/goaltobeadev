package com.htc.i18n.locale;

import java.util.Locale;

public class LocaleEx {
	public static void main(String[] args) {
		Locale[] locales = { new Locale("en", "US"), new Locale("es", "ES"), new Locale("fr", "FR") };

		for (int i = 0; i < locales.length; i++) {
			String displayLanguage = locales[i].getDisplayLanguage(locales[i]);
			System.out.println(locales[i].toString() + ": " + displayLanguage);
		}
	}

}