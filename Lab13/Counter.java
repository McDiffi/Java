package Lab13;

public class Counter implements Runnable{
    protected long count = 0;

    public synchronized void add(long value) {
        this.count = this.count + value;
    }

    public long getCount() {
        return count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            this.add(1);
        }
    }
}
