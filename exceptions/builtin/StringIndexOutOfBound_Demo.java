package com.htc.exceptions.builtin;

//Java program to demonstrate StringIndexOutOfBoundsException
class StringIndexOutOfBound_Demo
{
 public static void main(String args[])
 {
     try {
         String a = "This is like chipping "; // length is 22
         char c = a.charAt(25); // accessing 25th element
         System.out.println(c);
     }
     catch(StringIndexOutOfBoundsException e) {
         System.out.println("StringIndexOutOfBoundsException");
         System.out.println(e.getMessage());
     }
 }
}