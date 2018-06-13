package pl.poznan.put.jipp;

public class Konsument implements Runnable {
    private static final long DEAFULT_DELAY = 20;
    private final String name;
    private int messageCount = 0;
    private SynchronizedQueue<Integer> queue;

    public Konsument(String name, SynchronizedQueue<Integer> queue){
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Integer msg = this.getMessage();
                System.out.println(name + " received: " + msg);
                messageCount++;

                Thread.sleep(DEAFULT_DELAY);
            } catch (InterruptedException e) {
                System.out.println(name + " interupted!");
                return;
            }
        }
    }

    public int getMessageCount(){
        return messageCount;
    }

    public Integer getMessage() throws InterruptedException {
        return queue.poll();
    }
}
