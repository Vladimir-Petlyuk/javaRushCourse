package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileReader = bufferedReader.readLine();
        String fileWriter = bufferedReader.readLine();
        FileReader fileReader1 = new FileReader(fileReader);
        FileWriter fileWriter1 = new FileWriter(fileWriter);
        ArrayList<Integer> list = new ArrayList<>();
        while (fileReader1.ready()){
            list.add(fileReader1.read());
        }
        for (int i=1; i<list.size();i++){
            if(i%2!=0){
                fileWriter1.write(list.get(i));
            }
        }
        bufferedReader.close();
        fileReader1.close();
        fileWriter1.close();
    }
}
