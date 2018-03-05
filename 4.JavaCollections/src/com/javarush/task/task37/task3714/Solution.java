package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    private static HashMap<String, Integer> map = new HashMap<>();

    static {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }

    public static int romanToInteger(String s) {
        int result = 0;
        if (s.length() == 1)
            return map.get(s);
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {

            if (i != 0 && map.containsKey(String.valueOf(arr[i - 1]) + String.valueOf(arr[i]))) {
                result += map.get(String.valueOf(arr[i - 1]) + String.valueOf(arr[i]));
                i--;
            } else {
                result += map.get(String.valueOf(arr[i]));
            }
        }
        return result;
    }
}
