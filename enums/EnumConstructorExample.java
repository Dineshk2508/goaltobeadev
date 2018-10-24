package com.htc.corejava.enums;
public class EnumConstructorExample 
{ 
    public static void main(String args[]) 
    { 
        // let's print name of each enum and there action 
        // - Enum values() examples 
        //TrafficSignal[] signals = TrafficSignal.values(); 
  
        for (TrafficSignal signal : TrafficSignal.values()) 
        { 
            // use getter method to get the value 
            System.out.println("name : " + signal.name() + 
                        " action: " + signal.getAction() ); 
        } 
    } 
} 