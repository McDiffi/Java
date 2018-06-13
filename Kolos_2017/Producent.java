package pl.poznan.put.jipp;

import java.security.SecureRandom;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Producent implements Runnable{
    private static final int DEFAULT_DELAY = 100;
    private int messageCount = 0;
    private SynchronizedQueue<Integer> queue;
    private String name;

    public Producent(String name, SynchronizedQueue<Integer> queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                putMessage();
                messageCount++;
                Thread.sleep(DEFAULT_DELAY);
            } catch (InterruptedException e) {
                System.out.println(name + " interupted!");
                return;
            }
        }
    }

    public int getMessageCount(){ return messageCount; }

    private void putMessage() throws InterruptedException {
        queue.add(ThreadLocalRandom.current().nextInt(0, 100+1));
    }

    /*
    public Integer getMessage() throws InterruptedException {
        return queue.poll();
    }
    */
}
