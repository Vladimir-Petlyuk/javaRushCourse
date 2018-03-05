package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("E://JAVA/JavaRash/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs/"));
//        System.out.println(logParser.getNumberOfUniqueIPs(null, null));
//        System.out.println(logParser.getUniqueIPs(null, new Date()));
//        System.out.println(logParser.getIPsForUser("Amigo",null, new Date()));
//        System.out.println(logParser.getIPsForEvent(Event.DONE_TASK,null, new Date()));
//        System.out.println(logParser.getIPsForStatus(Status.OK,null, null));
//        System.out.println(logParser.getDateWhenUserSolvedTask("Amigo",18,new Date(), null));
//        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Amigo",null, null));
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(new Date(), null));
    }
}