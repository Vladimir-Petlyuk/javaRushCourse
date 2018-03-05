package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        StringBuilder stringBuilder = new StringBuilder();

        try {
                int i = string.indexOf("\t");
                stringBuilder.append(string.substring(i+1, string.indexOf("\t", i+1)));
            } catch (Exception e) {
                throw new TooShortStringException();
            }
        return stringBuilder.toString();
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
