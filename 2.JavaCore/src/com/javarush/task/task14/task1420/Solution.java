package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a=scanner.nextInt();
        if(a<=0){
            throw new NumberFormatException();
        }
        int b= scanner.nextInt();
        if(b<=0){
            throw new NumberFormatException();
        }
        System.out.println(gcd(a,b));
    }
    public static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b;

    }
}
