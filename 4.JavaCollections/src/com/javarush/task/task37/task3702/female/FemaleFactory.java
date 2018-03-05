package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;
import com.javarush.task.task37.task3702.male.KidBoy;
import com.javarush.task.task37.task3702.male.Man;
import com.javarush.task.task37.task3702.male.TeenBoy;

/**
 * Created by Владимир on 30.10.2017.
 */
public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age){
        Human human=null;
        if(age<=12)
            return human=new KidGirl();
        else if(age>12&&age<=19)
            return human=new TeenGirl();
        else return human=new Woman();
    }
}
