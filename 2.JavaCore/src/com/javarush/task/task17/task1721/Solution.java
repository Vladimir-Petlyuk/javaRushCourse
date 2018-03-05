package com.javarush.task.task17.task1721;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        scanner.close();
        FileReader fileReader1 = new FileReader(s1);
        Scanner scanner1 = new Scanner(fileReader1);
        FileReader fileReader2 = new FileReader(s2);
        Scanner scanner2 = new Scanner(fileReader2);
        while (scanner1.hasNext()) {
            allLines.add(scanner1.nextLine());
        }
        while (scanner2.hasNext()) {
            forRemoveLines.add(scanner2.nextLine());
        }
        scanner1.close();
        scanner2.close();
        Solution solution = new Solution();
        try {
            solution.joinData();
        }catch (CorruptedDataException e){}

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
