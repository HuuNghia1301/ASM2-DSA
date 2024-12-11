public class StudentStack {
    private Student[] stack;
    private int top;
    public int capacity;

    // Constructor
    public StudentStack(int capacity) {
        this.capacity = capacity;
        this.stack = new Student[capacity];
        this.top = -1;
    }

    // Push a student onto the stack
    public void push(Student student) {
        if (top < capacity - 1) {
            stack[++top] = student;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    // Pop a student from the stack
    public Student pop() {
        if (top >= 0) {
            Student student = stack[top];
            stack[top--] = null;  // Remove reference
            return student;
        } else {
            System.out.println("Stack Underflow");
            return null;
        }
    }

    // Peek the top student of the stack
    public Student peek() {
        if (top >= 0) {
            return stack[top];
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}
