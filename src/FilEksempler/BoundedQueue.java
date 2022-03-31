package FilEksempler;

public class BoundedQueue {
    protected Object[] a;
    protected int front, back, size, count;
    public BoundedQueue(int size) {
        if (size > 0) {
            this.size = size;
            a = new Object[size];
            back = size - 1;
        }
    }
    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return count == size; }
    public int getCount() { return count; }

    // put, get

    public void put(Object obj) {
        if (obj != null && !isFull()) {
            back = (back + 1) % size;
            a[back] = obj;
            count++;
        }
    }
    public Object get() {
        if (!isEmpty()) {
                Object result = a[front];
            a[front] = null;
            front = (front + 1) % size;
            count--;
            return result;
        }
        return null;
    }
}
