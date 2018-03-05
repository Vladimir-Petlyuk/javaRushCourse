package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException {
        A a =null;
        try {
            Object object = objectStream.readObject();
             a = (A) object;
            objectStream.close();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
        return a;
    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
