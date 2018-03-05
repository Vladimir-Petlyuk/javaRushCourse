package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            FileInputStream fileInputStream = new FileInputStream("");

        } catch (Exception e) {
            exceptions.add(e);}
        try {
            int [] arr= new int [0];
            int a= arr[10];

        } catch (Exception e) {
            exceptions.add(e);}
        try {
            Integer i=null;
            int a= i;

        } catch (Exception e) {
            exceptions.add(e);}
        try {

            FileOutputStream fileOutputStream = new FileOutputStream("");

        } catch (Exception e) {
            exceptions.add(e);}
        try {
            int [] arr= new int [5];
            arr[10]=45;

        } catch (Exception e) {
            exceptions.add(e);}
        try {
            String[] catNames = {"Васька", "Барсик", "Мурзик"};
            catNames[3] = "Рыжик";

        } catch (Exception e) {
            exceptions.add(e);}
        try {
          int [] a = new int[-9];

        } catch (Exception e) {
            exceptions.add(e);}
        try {
            int [] a = new int[-10];

        } catch (Exception e) {
            exceptions.add(e);}
        try {
            int [] a = new int[-45];

        } catch (Exception e) {
            exceptions.add(e);}







        //напишите тут ваш код

    }
}
