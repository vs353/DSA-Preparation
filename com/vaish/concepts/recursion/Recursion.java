package com.vaish.concepts.recursion;

public class Recursion {
    static int count =0;
    public static void f(){
        //When a function calls itself, until a specified condition is met
        if(count ==4){
            return;
        }
        System.out.println(count);
        count++;
        f();
    }
}
