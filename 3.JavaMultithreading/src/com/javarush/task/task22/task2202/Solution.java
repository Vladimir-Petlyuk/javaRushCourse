package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java. sdfsdfsd"));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        StringBuilder rezult =new StringBuilder();
        try{
            String[] s= string.split(" ");
//            int i = string.indexOf(" ");
            for(int i=1;i<5;i++){
                rezult.append(s[i]).append(" ");
            }

        }catch (Exception e){
            throw new TooShortStringException();
        }
        return rezult.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
