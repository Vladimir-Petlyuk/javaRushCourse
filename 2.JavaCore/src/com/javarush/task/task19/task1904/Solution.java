package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] s = fileScanner.nextLine().split(" ");
            String lastName = s[0];
            String firstName = s[1];
            String middleName = s[2];
            String s1 = s[3]+" ".concat(s[4]+" ").concat(s[5]);
            Date birthDate = new Date(s1);
            return new Person(firstName,middleName,lastName,birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}
