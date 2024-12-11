 public class Stack {
        private int maxSize;    // Kích thước tối đa của Stack
        private int top;        // Chỉ số của phần tử trên cùng
        private int[] stackArray; // Mảng lưu trữ các phần tử của Stack

        // Constructor khởi tạo Stack với kích thước tối đa
        public Stack(int size) {
            this.maxSize = size;
            this.stackArray = new int[size]; // Tạo mảng với kích thước tối đa
            this.top = -1; // Stack bắt đầu trống
        }

        // Hàm kiểm tra Stack có rỗng không
        public boolean isEmpty() {
            return top == -1; // Nếu top = -1, Stack rỗng
        }

        // Hàm kiểm tra Stack có đầy không
        public boolean isFull() {
            return top == maxSize - 1; // Nếu top = maxSize - 1, Stack đầy
        }

        // Hàm Push: Thêm phần tử vào Stack
        public void push(int value) {
            if (isFull()) {
                System.out.println("Stack is full! Cannot push " + value);
            } else {
                stackArray[++top] = value; // Tăng top lên và thêm phần tử vào mảng
                System.out.println("Pushed: " + value);
            }
        }

        // Hàm Pop: Loại bỏ phần tử trên cùng khỏi Stack
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty! Cannot pop.");
                return -1; // Trả về giá trị lỗi nếu Stack rỗng
            } else {
                int value = stackArray[top--]; // Lấy giá trị phần tử trên cùng và giảm top
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
                return stackArray[top]; // Trả về phần tử trên cùng
            }
        }
    }