package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        FileInputStream bufferedReader = new FileInputStream(s);
        load(bufferedReader);

    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter printWriter = new PrintWriter(outputStream);
        Properties properties1 = new Properties();
        for (Map.Entry<String, String> pair : properties.entrySet()) {
            properties1.put(pair.getKey(),pair.getValue());
        }
        properties1.store(printWriter, "");
    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Properties properties1 = new Properties();
        properties1.load(reader);
        for (Map.Entry<Object, Object> map : properties1.entrySet()) {
            properties.put((String) map.getKey(), (String) map.getValue());
        }
    }


    public static void main(String[] args) {

    }
}
