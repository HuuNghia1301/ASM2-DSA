public class PushDemo {
    public void push(StackDemo stack, int data) {
        Node newNode = new Node(data); // Tạo một Node mới
        newNode.next = stack.top; // Liên kết Node mới với phần tử trên cùng
        stack.top = newNode; // Đặt Node mới làm phần tử trên cùng
        System.out.println("Pushed: " + data);
    }
}
