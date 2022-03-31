package FilEksempler;

public class SyncBoundedQueue extends BoundedQueue {
    public SyncBoundedQueue(int size) { super(size); }
    public synchronized boolean isEmpty() { return super.isEmpty(); }
    public synchronized boolean isFull() { return super.isFull(); }
    public synchronized int getCount() { return super.getCount(); }
    public synchronized void put(Object obj) { super.put(obj); }
    public synchronized Object get() { return super.get(); }
}