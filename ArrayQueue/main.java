package ArrayQueue;
public class main {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Phần tử đầu tiên: " + queue.peek()); // Kết quả: 10
        System.out.println("Xóa phần tử: " + queue.dequeue());  // Kết quả: 10

        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Số lượng phần tử hiện tại: " + queue.getSize()); 
    }
}
