package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {
        List list = ArmstrongNumbersMultiSetLongOpt.generate((int) (Math.log10(N) + 1));
        long[] arr=new long[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]= (long) list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        Long t1 = System.currentTimeMillis();
        System.out.println("Time  = " + (t1 - t0)+"ms");
        System.out.println("memory: " + (double)(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");


    }
}
