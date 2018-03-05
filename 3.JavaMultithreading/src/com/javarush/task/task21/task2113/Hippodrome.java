package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владимир on 28.04.2017.
 */
public class Hippodrome {
    private List<Horse>  horses;
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
     public void run() throws InterruptedException {
        for(int i=0; i<100;i++){
            move();
            print();
            Thread.sleep(200);
        }
     }
     public void move(){
        for(Horse horse:horses){
            horse.move();
        }
     }
     public  void print(){
         for(Horse horse:horses){
             horse.print();
         }
         for(int i=0;i<10;i++){
             System.out.println();
         }
     }
    public Horse getWinner(){
         Horse horse = horses.get(0);
         for(Horse horse1:horses){
             if(horse.getDistance()<horse1.getDistance()){
                 horse=horse1;
             }
         }
         return horse;
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }

    public static void main(String[] args) throws InterruptedException {
        Horse horse = new Horse("1",3,0);
        Horse horse1 = new Horse("2",3,0);
        Horse horse2 = new Horse("3",3,0);
        List<Horse> h = new ArrayList<>();
        h.add(horse);
        h.add(horse1);
        h.add(horse2);

        Hippodrome.game = new Hippodrome(h);
        game.run();
        game.printWinner();
    }
}
