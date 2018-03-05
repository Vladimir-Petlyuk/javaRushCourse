package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "sd", "se", "sa", "sg", "sn", "sl", "su", "sf"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (String str : words) {
            Word word = new Word(str);
            word.setStartPoint(0, 0);
            word.setEndPoint(0, 0);

            char[] chars = str.toCharArray();
            int l = chars.length - 1;
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (i + l < crossword.length && chars[chars.length - 1] == crossword[i + l][j] && chars[0] == crossword[i][j]) {
                        word.setStartPoint(j, i);
                        word.setEndPoint(j, i + l);
                    } else if (i - l >= 0 && i - l < crossword.length && chars[chars.length - 1] == crossword[i - l][j] && chars[0] == crossword[i][j]) {
                        word.setEndPoint(j, i - l);
                        word.setStartPoint(j, i);
                    } else if (j + l < crossword.length && chars[chars.length - 1] == crossword[i][j + l] && chars[0] == crossword[i][j]) {
                        word.setEndPoint(j + l, i);
                        word.setStartPoint(j, i);
                    } else if (j - l >= 0 && j - l < crossword.length && chars[chars.length - 1] == crossword[i][j - l] && chars[0] == crossword[i][j]) {
                        word.setEndPoint(j - l, i);
                        word.setStartPoint(j, i);
                    } else if (i - l >= 0 && i - l < crossword.length && j - l >= 0 && j - l < crossword.length && chars[chars.length - 1] == crossword[i - l][j - l] && chars[0] == crossword[i][j]) {
                        word.setEndPoint(j - l, i - l);
                        word.setStartPoint(j, i);
                    } else if (i + l < crossword.length && j - l >= 0 && j - l < crossword.length && chars[chars.length - 1] == crossword[i + l][j - l] && chars[0] == crossword[i][j]) {
                        word.setEndPoint(j - l, i + l);
                        word.setStartPoint(j, i);
                    } else if (i + l < crossword.length && j + l < crossword.length && chars[chars.length - 1] == crossword[i + l][j + l] && chars[0] == crossword[i][j]) {
                        word.setEndPoint(j + l, i + l);
                        word.setStartPoint(j, i);
                    } else if (i - l >= 0 && i - l < crossword.length && j + l < crossword.length && chars[chars.length - 1] == crossword[i - l][j + l] && chars[0] == crossword[i][j]) {
                        word.setEndPoint(j + l, i - l);
                        word.setStartPoint(j, i);
                    }

                }
            }
            list.add(word);
        }
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
