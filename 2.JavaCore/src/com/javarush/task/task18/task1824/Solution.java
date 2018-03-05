package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = buf.readLine();
            try (FileInputStream file = new FileInputStream(s)){

            } catch (FileNotFoundException e) {
                System.out.println(s);
                break;
            }
        }
        buf.close();
    }
}
