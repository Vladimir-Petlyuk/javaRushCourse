package com.javarush.task.task12.task1209;

/*
Три метода возвращают минимальное из двух переданных в него чисел
*/

public class Solution {
    public static void main(String[] args) {

    }
    public static int min(int i, int j){
        return i>j?j:i;
    }
    public static long min(long i, long j){
        return i>j?j:i;
    }
    public static double min(double i, double j){
        return i>j?j:i;
    }
}
