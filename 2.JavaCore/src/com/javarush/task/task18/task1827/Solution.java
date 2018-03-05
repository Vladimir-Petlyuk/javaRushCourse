package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        if (args[0].equals("-c")){
            ArrayList<String>list = new ArrayList<>();
            while (reader.ready()){
                String s = reader.readLine();
                if (!s.equals("")) {
                    list.add(s);
                }
            }
            reader.close();
            bufferedReader.close();
            String max = list.get(list.size()-1).substring(0,8).replaceAll(" ", "");
            int max1 = Integer.parseInt(max)+1;
            StringBuilder productNameDemo = new StringBuilder();
            for (int i=1; i<args.length-2;i++){
                productNameDemo.append(args[i]);
                productNameDemo.append(" ");
            }
            String productName = productNameDemo.toString().trim();
            String price = args[args.length-2];
            String quantity = args[args.length-1];
            list.add(String.format("%-8d%-30.30s%-8s%-4s", max1, productName, price, quantity));
            FileWriter fileWriter = new FileWriter(fileName);
            for (String str:list){
                fileWriter.write(str+"\r\n");
            }
            fileWriter.close();
        }
    }
}


