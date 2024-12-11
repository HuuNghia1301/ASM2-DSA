package ArrayQueue;
public class ArrayQueue {
    private int[] queue;   
    private int front;     
    private int rear;      
    private int size;      
    private int capacity;  

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new IllegalStateException("Hàng đợi đã đầy");
        }
        rear = (rear + 1) % capacity; 
        queue[rear] = element;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Hàng đợi rỗng");
        }
        int element = queue[front];
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Hàng đợi rỗng");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }
}
