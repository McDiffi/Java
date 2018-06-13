package pl.poznan.put.jipp;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int i;
        do {
            System.out.println("Wpisz numer zadania (1-3): ");
            Scanner input = new Scanner(System.in);
            i = input.nextInt();

            switch(i){
                case 1:{
                    Bike bike = new Bike();
                    try {
                        bike.move(9);
                        bike.move(12);
                    } catch (Vehicle.MoveException e) {
                        System.out.println(e.toString());
                    }
                    break;
                }
                case 2:{
                    try {
                        UniqueWordCounter counter = new UniqueWordCounter("macbeth.txt");
                        //counter.display();
                        //counter.displayUnique();
                        counter.countWords("w");

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3:{
                    SynchronizedQueue<Integer> queue = new SynchronizedQueue<Integer>(5);
                    Producent producer1 = new Producent("Prod1", queue);
                    Producent producer2 = new Producent("Prod1", queue);
                    Konsument consumer = new Konsument("Wojtek", queue);
                    Thread p1 = new Thread(producer1);
                    Thread p2 = new Thread(producer2);
                    Thread c = new Thread(consumer);

                    p1.start();
                    p2.start();
                    c.start();

                    Thread.sleep(5000);
                    p1.interrupt();
                    p2.interrupt();
                    c.interrupt();

                    System.out.println("\nProduced " + producer1.getMessageCount() + " messages.");
                    System.out.println("\nProduced " + producer2.getMessageCount() + " messages.");
                    System.out.println("\nConsumed " + (consumer.getMessageCount()) + " messages.");
                    System.out.println("\nMain thread stopped.");

                    break;
                }
                default:{
                    break;
                }
            }

        } while (i != 0);
    }
}
