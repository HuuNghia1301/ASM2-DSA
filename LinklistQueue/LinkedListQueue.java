package LinklistQueue;

public class LinkedListQueue {
    private Node front; // Phần tử đầu
    private Node rear;  // Phần tử cuối
    private int size;   // Số lượng phần tử

    // Lớp Node
    private static class Node {
        int data;      // Giá trị
        Node next;     // Trỏ đến node tiếp theo

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Thêm phần tử vào hàng đợi
    public void enqueue(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            front = rear = newNode; // Nếu rỗng, cả front và rear trỏ đến node mới
        } else {
            rear.next = newNode;   // Gán node mới sau rear
            rear = newNode;        // Cập nhật rear
        }
        size++;
    }

    // Xóa phần tử khỏi hàng đợi
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Hàng đợi rỗng");
        }
        int element = front.data; // Lấy dữ liệu tại front
        front = front.next;       // Di chuyển front đến node tiếp theo
        if (front == null) {
            rear = null;          // Nếu hàng đợi rỗng, cập nhật rear thành null
        }
        size--;
        return element;
    }

    // Lấy phần tử đầu tiên mà không xóa
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Hàng đợi rỗng");
        }
        return front.data;
    }

    // Kiểm tra hàng đợi rỗng
    public boolean isEmpty() {
        return front == null;
    }

    // Lấy số lượng phần tử hiện tại
    public int getSize() {
        return size;
    }
}

