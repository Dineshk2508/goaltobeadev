package com.htc.i18n.locale;
import java.util.Locale;
public class CountryAndLangs {

 public static void main(String[] args){
    
	 
	 
  String[] countries = Locale.getISOCountries();  // returns all country code
  String[] langs = Locale.getISOLanguages();   // all language code
  
  System.out.println("supported countries");
  for(String  ctr : countries) {
   System.out.print(ctr + "\t");
  }
  System.out.println("\nsupported languages");
  for(String  lnr : langs){
   System.out.print(lnr + "\t");
  }
 }

}