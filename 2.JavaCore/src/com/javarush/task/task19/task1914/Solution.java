package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result=outputStream.toString().replace("\r\n","");
        String[] arr = result.split(" ");
        System.setOut(consoleStream);
        int i = Integer.parseInt(arr[0]);
        String znak = arr[1];
        int j = Integer.parseInt(arr[2]);
        int sum = 0;
        if (znak.equals("+")) {
            sum = i + j;
        } else if(znak.equals("-")){ sum = i - j;}else if (znak.equals("*")){sum = i*j;}
        System.out.println(result + sum);
    }


    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

