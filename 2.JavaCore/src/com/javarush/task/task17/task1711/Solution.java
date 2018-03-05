package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        switch (args[0]) {


            case "-i": {
                synchronized (allPeople) {

                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));

                        System.out.println(person.getName() + " " + ((person.getSex()).equals(Sex.MALE) ? "м" : "ж") + " " + format.format(person.getBirthDay()));

                    }
                }
                break;
            }

            case "-d": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {

                        Person person = allPeople.remove(Integer.parseInt(args[i]));
                        person.setBirthDay(null);
                        person.setName(null);
                        person.setSex(null);
                        allPeople.add(Integer.parseInt(args[i]), person);


                    }
                }
                break;
            }

            case "-u": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {

                        Date date;
                        date = ft.parse(args[i + 3]);
                        Person person = allPeople.remove(Integer.parseInt(args[i]));
                        person.setName(args[i + 1]);
                        person.setSex(args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE);
                        person.setBirthDay(date);
                        allPeople.add(Integer.parseInt(args[i]), person);

                    }
                }
                break;
            }

            case "-c": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {

                        Date date;
                        date = ft.parse(args[i + 2]);
                        if (args[i + 1].equals("м")) {
                            allPeople.add(Person.createMale(args[i], date));
                        } else if (args[i + 1].equals("ж")) {
                            allPeople.add(Person.createFemale(args[i], date));
                        }

                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            }

            default:
                synchronized (allPeople) {
                    break;
                }
        }
    }
}