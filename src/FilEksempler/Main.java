package FilEksempler;

public class Main {


    public static void main(String args[]) {
        BoundedQueue queue = new SyncBoundedQueue(5);
        new Producer(queue, 15).start();
        new Consumer(queue, 10).start();
    }
}
