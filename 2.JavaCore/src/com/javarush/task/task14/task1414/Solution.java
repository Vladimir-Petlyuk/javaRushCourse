package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Movie> list = new ArrayList<>();
        Movie movie = null;
        while (true) {
            String s = scanner.nextLine();
            if (s.equals("soapOpera")) {
                list.add(movie = MovieFactory.getMovie(s));
            } else if (s.equals("cartoon")) {
                list.add(movie = MovieFactory.getMovie(s));
            } else if (s.equals("thriller")) {
                list.add(movie = MovieFactory.getMovie(s));
            } else {
                movie = MovieFactory.getMovie(s);
                break;
            }
        }
        for (Movie movie1 : list) {
            System.out.println(movie1.getClass().getSimpleName());
        }

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            } else if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {

    }

    static class Thriller extends Movie {

    }
}
