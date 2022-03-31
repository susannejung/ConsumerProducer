package FilEksempler;

public class Consumer extends Thread {
    protected BoundedQueue queue;
    protected int n;
    public Consumer(BoundedQueue queue, int n) {
        this.queue = queue; this.n = n;
    }
    public void run() {
        for (int i = 0; i < n; i++) {
            Object obj = queue.get();
            if (obj != null)
                System.out.println("\tconsume: " + obj);
            try {
                sleep((int)(Math.random() * 400));
            } catch (InterruptedException e) {}
        }
    }
}
