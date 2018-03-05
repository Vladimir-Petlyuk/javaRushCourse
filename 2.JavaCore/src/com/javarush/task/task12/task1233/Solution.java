package com.javarush.task.task12.task1233;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Index of minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        Integer min = null;
        Integer ind = 0;
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        } else
            min = array[0];

            for (int i = 0; i<array.length; i++){
                if(array[i]<min){
                    min=array[i];
                    ind = i;
                }
            }

        //напишите тут ваш код

        return new Pair<Integer, Integer>(min, ind);
    }


    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
