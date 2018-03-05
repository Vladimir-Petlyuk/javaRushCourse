package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {

    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels=new ArrayList<>();

        public Car()  {
            String[] array=loadWheelNamesFromDB();
            if (array.length != 4){
                throw new IllegalArgumentException();}
                for (String anArray : array) {
                    wheels.add(Wheel.valueOf(anArray));
            }
        }


        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
