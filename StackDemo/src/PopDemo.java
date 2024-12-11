public class PopDemo {
    public int pop(StackDemo stack) {
        if (stack.top == null) {
            System.out.println("Stack underflow! Cannot pop from an empty stack.");
            return -1; // Trả về giá trị đại diện
        }
        int poppedData = stack.top.data; // Lưu giá trị phần tử trên cùng
        stack.top = stack.top.next; // Di chuyển con trỏ top
        System.out.println("Popped: " + poppedData);
        return poppedData;
    }
}
