package Lab13;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        int i;

        do {
            System.out.print("Wpisz numer zadania (1-10, 0 - aby wyjść!) \n");
            i = input.nextInt();

            switch (i) {
                case 1: {
                    System.out.print("Zadanie 1: \n");
                    Thread t1 = new Thread(new Countdown("t1", 10));
                    t1.start();
                    /*
                    while(t1.isAlive()){
                        continue;
                    }
                    */

                    t1.join();
                    //Sposób ze sprawdzaniem czy wątek jest aktywny w pętli na pewno będzie mniej wydajny, niż wbudowana funkcja join, która po prostu czeka na zakończenie wątku
                    System.out.println("Main thread run is over");
                    break;
                }
                case 2: {
                    System.out.print("Zadanie 2: \n");
                    Thread racer1 = new Thread(new Countdown("racer 1", 20));
                    Thread racer2 = new Thread(new Countdown("racer 2", 20));

                    racer1.start();
                    racer2.start();

                    racer1.join();
                    racer2.join();

                    System.out.println("Race is over");
                    break;
                }
                case 3: {
                    System.out.print("Zadanie 3: \n");
                    Counter counter = new Counter();

                    Thread t1 = new Thread(counter);
                    Thread t2 = new Thread(counter);
                    Thread t3 = new Thread(counter);

                    t1.start();
                    t2.start();
                    t3.start();

                    t1.join();
                    t2.join();
                    t3.join();

                    System.out.println("Stan Counter'a: " + counter.getCount());
                    // Wynik jest inny dla wywołania metody run() w 3 wątkach, niż w 3 wątkach ze względu na to, że korzystamy z tej samej zmienniej. którą kązdy z wątków modyfikuje
                    break;
                }
                case 4: {
                    System.out.print("Zadanie 4: \n");

                    ArrayList<Integer> numbers = new ArrayList<>();
                    Vector<Integer> numbersVector = new Vector<>();

                    ArrayList<Thread> threads = new ArrayList<>();

                    Scanner gettn = new Scanner(System.in);

                    System.out.print("Podaj liczbę wątków do utworzenia: \n");
                    int t = gettn.nextInt();
                    System.out.print("Podaj liczbę liczb do dodania przez każdy wątek: \n");
                    int n = gettn.nextInt();

                    for(int q = 0; q < t; q++){
                        threads.add(new Thread(){
                            @Override
                            public void run() {
                                for(int j = 0; j < n; j++) numbers.add(ThreadLocalRandom.current().nextInt(n+1));
                            }
                        });
                    }

                    for(Thread thread: threads){
                        thread.start();
                    }

                    for(Thread thread: threads){
                        thread.join();
                    }

                    threads.clear();

                    for(int q = 0; q < t; q++){
                        threads.add(new Thread(){
                            @Override
                            public void run() {
                                for(int j = 0; j < n; j++) numbersVector.add(ThreadLocalRandom.current().nextInt(n+1));
                            }
                        });
                    }

                    for(Thread thread: threads){
                        thread.start();
                    }

                    for(Thread thread: threads){
                        thread.join();
                    }

                    System.out.println("Ilość elementów w liście: " + numbers.size());
                    System.out.println("Ilość elementów w wektorze: " + numbersVector.size());
                    //Powinno być t * n
                    // Wyniki są różne dla dużej ilości wywołań, gdyż metody wktora są synchronizowane w przeciwieństwie do implementacji innych kolekcji. Zgodnie z dokumentacją Oracle'a (ponizej fragment):
                    //Unlike the new collection implementations, Vector is synchronized. If a thread-safe implementation is not needed, it is recommended to use ArrayList in place of Vector.
                    break;
                }
                case 5: {
                    System.out.print("Zadanie 5: \n");

                    long startTime = System.nanoTime();

                    try {
                        System.out.println("Not pararell processing: W pliku macbeth.txt jest " +
                                Files.lines(new File("macbeth.txt").toPath())
                                .flatMap((line) -> Arrays.stream(line.toLowerCase().split("\\W+")))
                                .distinct().filter(word -> word.length() > 2).count()
                                + " unikalnych słów \n Execution time: " + (System.nanoTime() - startTime));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    startTime = System.nanoTime();

                    try {
                        System.out.println("Pararell processing: \t W pliku macbeth.txt jest " +
                                Files.lines(new File("macbeth.txt").toPath())
                                        .parallel()
                                        .flatMap((line) -> Arrays.stream(line.toLowerCase().split("\\W+")))
                                        .distinct().filter(word -> word.length() > 2).count()
                                + " unikalnych słów \n Execution time: " + (System.nanoTime() - startTime));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                }
                case 6: {
                    System.out.print("Zadanie 6: \n");
                    Producer producer = new Producer();
                    Consumer consumer1 = new Consumer("Consumer 1 ", producer);
                    Consumer consumer2 = new Consumer("Consumer 2 ", producer);

                    Thread p = new Thread(producer);
                    Thread c1 = new Thread(consumer1);
                    Thread c2 = new Thread(consumer2);

                    p.start();
                    c1.start();
                    c2.start();

                    Thread.sleep(3000);
                    p.interrupt();
                    p.join();

                    System.out.println("\nProduced " + producer.getMessageCount() + " messages.");

                    Thread.sleep(500);

                    c1.interrupt();
                    c2.interrupt();

                    c1.join();
                    c2.join();

                    System.out.println("\nConsumed " + (consumer1.getMessageCount() + consumer2.getMessageCount()) + " messages.");
                    System.out.println("\nMain thread stopped.");

                    break;
                }
                default: {
                    break;
                }
            }
        } while (i != 0);
    }
}

