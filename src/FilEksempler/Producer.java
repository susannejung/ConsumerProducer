package FilEksempler;


public class Producer extends Thread {
    protected BoundedQueue queue;
    protected int n;
    public Producer(BoundedQueue queue, int n) {
        this.queue = queue; this.n = n;
    }
    public void run() {
        for (int i = 0; i < n; i++) {
            queue.put(new Integer(i));
            System.out.println("produce: " + i);
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {}
        }
    }
}
