package FilEksempler;


public class BoundedQueueWithGuard extends BoundedQueue {
    public BoundedQueueWithGuard(int size) { super(size); }
    public synchronized boolean isEmpty() { return super.isEmpty(); }
    public synchronized boolean isFull() { return super.isFull(); }
    public synchronized int getCount() { return super.getCount(); }

    public synchronized void put(Object obj)
    {
        try {
        while (isFull())
            wait();
    } catch (InterruptedException e) {}
        super.put(obj);
        notify();
    }

    public synchronized Object get()
    {
        try {
            while (isEmpty())
                wait();
        } catch (InterruptedException e) {}
        Object result = super.get();
        notify();
        return result;
    }

    public static void main(String args[]) {
        BoundedQueueWithGuard queue = new BoundedQueueWithGuard(5);
        new Producer(queue, 15).start();
        new Consumer(queue, 10).start();
    }
}