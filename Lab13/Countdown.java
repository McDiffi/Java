package Lab13;

import java.util.concurrent.ThreadLocalRandom;

public class Countdown implements Runnable{
    private String name;
    private int limit;

    Countdown(String name, int limit){
        this.name = name;
        this.limit = limit;
    }

    private int radomTime(){
        return ThreadLocalRandom.current().nextInt(1000 + 1);
    }

    public void run(){
        for (int i = limit; i > 0; i--) { System.out.println(name + ": " + i);
            try {
                Thread.sleep(radomTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}
