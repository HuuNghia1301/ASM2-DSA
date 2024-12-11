public class PeekDemo {
    public int peek(StackDemo stack) {
        if (stack.top == null) {
            System.out.println("Stack is empty! No top element.");
            return -1; // Trả về giá trị đại diện
        }
        return stack.top.data;
    }
}
