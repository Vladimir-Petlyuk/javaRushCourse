package com.javarush.task.task19.task1921;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        while (bufferedReader.ready()) {
            String s = bufferedReader.readLine();
            String[] arr = s.split(" ");
            StringBuilder name = new StringBuilder();
            StringBuilder date = new StringBuilder();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            ArrayList<Integer>list = new ArrayList<>();
            for(String str:arr){
                try{
                int i = Integer.parseInt(str);
                    list.add(i);
                    date.append(str).append(" ");
            }catch (NumberFormatException e){
                    name.append(str).append(" ");
                }
            }
            PEOPLE.add(new Person(name.toString().trim(),new Date(list.get(2)-1900,list.get(1)-1,list.get(0))));
        }
        bufferedReader.close();
        System.out.println(PEOPLE);

    }
}
