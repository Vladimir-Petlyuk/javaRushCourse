package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isCanel=true;
        while (isCanel){
            String s = reader.readLine();
            FileInputStream file = new FileInputStream(s);

            if (file.available()<1000){

                file.close();
                isCanel=false;
                throw  new DownloadException();
            }
        }
        reader.close();

    }

    public static class DownloadException extends Exception {

    }
}
