public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println("Stack created successfully!");

        // Thực hiện các thao tác trên Stack
        stack.push(10);  // Thêm 10 vào Stack
        stack.push(20);  // Thêm 20 vào Stack
        stack.push(30);  // Thêm 30 vào Stack

        // Kiểm tra phần tử trên cùng
        System.out.println("Top element is: " + stack.peek());

        // Thực hiện thao tác Pop
        stack.pop();     // Loại bỏ phần tử trên cùng
        stack.pop();     // Loại bỏ phần tử trên cùng

        // Kiểm tra Stack có rỗng không
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Thực hiện các thao tác pop cho tới khi Stack rỗng
        stack.pop();     // Loại bỏ phần tử trên cùng
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}