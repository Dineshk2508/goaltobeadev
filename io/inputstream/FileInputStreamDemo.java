package com.htc.io.inputstream;

import java.io.FileInputStream;
import java.io.IOException;

//Java program demonstrating FileInputStream  
class FileInputStreamDemo 
{ 
    public static void main(String args[]) throws IOException 
    { 
  
        //attach the file to FileInputStream 
        FileInputStream fin= new FileInputStream("FileOutputStream.txt"); 
  
      
        //illustrating available method 
        System.out.println("Number of remaining bytes:"+fin.available()); 
  
        
        fin.skip(4); 
        System.out.println("FileContents :"); 
        //read characters from FileInputStream and write them 
        int ch; 
        while((ch=fin.read())!=-1) 
            System.out.print((char)ch); 
          
        //close the file 
        fin.close(); 
    } 
} 