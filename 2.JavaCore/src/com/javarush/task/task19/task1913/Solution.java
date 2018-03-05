package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
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
        String[] result = outputStream.toString().split(" ");
        System.setOut(consoleStream);
        for (String line:result){
            char[] arr = line.toCharArray();
            for (Character cha:arr){
                try{
                    int i = Integer.parseInt(String.valueOf(cha));
                    System.out.print(i);
                }catch (NumberFormatException e){
                    continue;
                }
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
