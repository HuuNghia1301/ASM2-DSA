public class StackStudent {
    private Student[] stack;
    private int top;
    public int capacity;

    // Constructor
    public StackStudent(int capacity) {
        this.capacity = capacity;
        this.stack = new Student[capacity];
        this.top = -1;  // Initializing stack as empty
    }

    // Kiểm tra nếu stack rỗng
    public boolean isEmpty() {
        return top == -1;
    }

    // Kiểm tra nếu stack đầy
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Thêm sinh viên vào stack
    public void push(Student student) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot add more students.");
        } else {
            stack[++top] = student;
        }
    }

    // Lấy sinh viên ra khỏi stack
    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No student to remove.");
            return null;
        } else {
            return stack[top--];
        }
    }

    // Lấy sinh viên ở trên cùng của stack mà không pop
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        } else {
            return stack[top];
        }
    }

    // Lấy số lượng sinh viên trong stack
    public int size() {
        return top + 1;
    }

        // Hoán đổi hai sinh viên trong stack
        public void swap(int i, int j) {
            if (i >= 0 && j >= 0 && i <= top && j <= top) {
                Student temp = stack[i];
                stack[i] = stack[j];
                stack[j] = temp;
            }
        }

    // Lấy sinh viên tại vị trí index cụ thể
    public Student get(int index) {
        if (index >= 0 && index <= top) {
            return stack[index];
        }
        return null;
    }
    public void clear() {
        top = -1;
    }
}
