public class Main {
    public static void main(String[] args) {
        // Tạo một Stack mới với kích thước tối đa là 5
        Stack stack = new Stack(5);

        // Thực hiện một số thao tác trên Stack
        System.out.println("Stack created successfully!");

        stack.push(10);  // Thêm 10 vào Stack
        stack.push(20);  // Thêm 20 vào Stack
        stack.push(30);  // Thêm 30 vào Stack
        stack.push(40);  // Thêm 40 vào Stack
        stack.push(50);  // Thêm 50 vào Stack
        stack.push(60);  // Thử thêm phần tử khi Stack đã đầy

        System.out.println("Top element is: " + stack.peek()); // Kiểm tra phần tử trên cùng

        stack.pop();  // Loại bỏ phần tử trên cùng
        stack.pop();  // Loại bỏ phần tử trên cùng

        System.out.println("Is stack empty? " + stack.isEmpty()); // Kiểm tra Stack có rỗng không

        stack.pop();  // Loại bỏ phần tử trên cùng
        stack.pop();  // Loại bỏ phần tử trên cùng
        stack.pop();  // Loại bỏ phần tử trên cùng
        System.out.println("Is stack empty? " + stack.isEmpty()); // Kiểm tra lại Stack có rỗng không
    }
}