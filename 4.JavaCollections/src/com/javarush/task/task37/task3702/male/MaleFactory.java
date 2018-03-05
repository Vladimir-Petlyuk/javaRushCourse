package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

/**
 * Created by Владимир on 30.10.2017.
 */
public class MaleFactory implements AbstractFactory {

    public Human getPerson(int age){
        Human human=null;
        if(age<=12)
            return human=new KidBoy();
        else if(age>12&&age<=19)
            return human=new TeenBoy();
        else return human=new Man();
    }
}
