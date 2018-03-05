package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 1, 1},
                {1, 0, 0, 0, 0}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        byte[][] a1 = a;
        int count = 0;
        int l = a.length;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1 && neighbours(a, i, j) >= 1) {
                    a[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
                if (a[i][j] == 1) {

                    count++;
                }
            }
            System.out.println();
        }
        return count;
    }

    public static int neighbours(byte[][] field, int i, int j) {
        int n = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int m = j - 1; m <= j + 1; m++) {
                if (k != i || m != j) {
                    if (k >= 0 && k <= field.length - 1) {
                        if (m >= 0 && m <= field[k].length - 1) {
                            if (field[k][m] == 1) {
                                n++;
                            }
                        }
                    }
                }
            }
        }
        return n;
    }
}
