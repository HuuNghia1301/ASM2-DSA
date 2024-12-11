public class Stack {
    private Node top; // Con trỏ tới phần tử trên cùng của Stack

    // Constructor khởi tạo Stack
    public Stack() {
        this.top = null; // Stack ban đầu rỗng
    }

    // Kiểm tra Stack có rỗng không
    public boolean isEmpty() {
        return top == null; // Nếu top là null, Stack rỗng
    }

    // Hàm Push: Thêm phần tử vào Stack
    public void push(int data) {
        Node newNode = new Node(data); // Tạo một Node mới với dữ liệu
        newNode.next = top; // Liên kết Node mới với phần tử hiện tại ở đỉnh
        top = newNode; // Đặt Node mới làm phần tử trên cùng
        System.out.println("Pushed: " + data);
    }

    // Hàm Pop: Loại bỏ phần tử trên cùng khỏi Stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return -1; // Trả về giá trị lỗi nếu Stack rỗng
        } else {
            int value = top.data; // Lấy giá trị phần tử trên cùng
            top = top.next; // Di chuyển top tới phần tử tiếp theo
            System.out.println("Popped: " + value);
            return value; // Trả về giá trị của phần tử đã bị loại bỏ
        }
    }

    // Hàm Peek: Lấy giá trị phần tử trên cùng mà không loại bỏ
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No top element.");
            return -1; // Trả về giá trị lỗi nếu Stack rỗng
        } else {
            return top.data; // Trả về phần tử trên cùng
        }
    }
}
