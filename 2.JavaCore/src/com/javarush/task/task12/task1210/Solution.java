package com.javarush.task.task12.task1210;

/* 
Три метода возвращают максимальное из двух переданных в него чисел
*/

public class Solution {
    public static void main(String[] args) {

    }
    public static int max(int i, int j){
        return i>j?i:j;
    }
    public static long max(long i, long j){
        return i>j?i:j;
    }
    public static double max(double i, double j){
        return i>j?i:j;
    }


    //Написать public static методы: int max(int, int), long max(long, long), double max(double, double).
//    Каждый метод должен возвращать максимальное из двух переданных в него чисел.
}
