package com.htc.i18n.locale;

import java.util.Locale;

public class LocaleDemo {

	public static void main(String[] args) {
		Locale[] locale=Locale.getAvailableLocales();
		for(Locale local:locale){
			System.out.println(local.getDisplayLanguage()+"--"+local.getDisplayCountry()+"("+local.getLanguage()+"--"+local.getCountry()+")");
		}
		System.out.println("Default Locale: "+Locale.getDefault());		
	}
}
