package com.javarush.task.task25.task2506;

/* 
Мониторинг состояния нити
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start();
        target.start();  //NEW
        Thread.sleep(100); //RUNNABLE
        target.join(100);
        Thread.sleep(400);
        target.interrupt(); //TERMINATED
        Thread.sleep(500);
    }
}
class LoggingStateThread extends Thread{
    private Thread target;
    public LoggingStateThread(Thread target) {
        System.out.println(target.getState());
        this.target = target;
    }

    public void run() {
        State state = target.getState();
        System.out.println(state);
        while (target.getState()!=State.TERMINATED) {
            if (target.getState() != state) {
                state = target.getState();
                System.out.println(state);
            }
        }
    }
}
