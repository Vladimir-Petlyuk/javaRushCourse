package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put( "age1", null);
        map.put("z","Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put( "age", null);
        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
                if (isFirst == false) {
                    sb.append(" and ");
                }
                sb.append(pair.getKey()).append(" = '").append(pair.getValue()).append("'");
                isFirst = false;
            }
        }
        return sb.toString();
    }
}
