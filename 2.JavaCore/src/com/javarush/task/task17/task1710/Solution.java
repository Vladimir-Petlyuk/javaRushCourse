package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        if (args.length == 2 && args[0].equals("-i")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));

            System.out.println(person.getName() + " " + ((person.getSex()).equals(Sex.MALE) ? "м" : "ж") + " " + format.format(person.getBirthDay()));

        } else if (args.length == 2 && args[0].equals("-d")) {
            Person person = allPeople.remove(Integer.parseInt(args[1]));
            person.setBirthDay(null);
            person.setName(null);
            person.setSex(null);
            allPeople.add(Integer.parseInt(args[1]), person);


        } else if (args.length == 5 && args[0].equals("-u")) {
            Date date;
            date = ft.parse(args[4]);
            Person person = allPeople.remove(Integer.parseInt(args[1]));
            person.setName(args[2]);
            person.setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
            person.setBirthDay(date);
            allPeople.add(Integer.parseInt(args[1]), person);

        } else if (args.length == 4 && args[0].equals("-c")) {
            Date date;
            date = ft.parse(args[3]);
            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], date));
            } else if (args[2].equals("ж")) {
                allPeople.add(Person.createFemale(args[1], date));
            }

            System.out.println(allPeople.size() - 1);
        }
    }
}
