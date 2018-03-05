package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Закрепляем Singleton pattern
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        Scanner scanner = new Scanner(System.in);
        String s=scanner.nextLine();
        if(s.equals(Planet.EARTH)){
            thePlanet = Earth.getInstance();
        }else if (s.equals(Planet.MOON)){
            thePlanet= Moon.getInstance();
        }else if(s.equals(Planet.SUN)){
            thePlanet=Sun.getInstance();
        }else thePlanet=null;
    }
}
