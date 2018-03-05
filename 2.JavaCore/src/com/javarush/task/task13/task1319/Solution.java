package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter file = new BufferedWriter(new FileWriter(bufferedReader.readLine()));

        while (true){
            String s= bufferedReader.readLine();
            if(s.equals("exit")){
                file.write(s+'\n');
                break;}
            else {
                file.write(s+'\n');
            }

        }
        bufferedReader.close();
        file.close();

    }

}
