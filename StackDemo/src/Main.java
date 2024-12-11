public class Main {
    public static void main(String[] args) {
        StackDemo stack = new StackDemo();
        PushDemo pushOperation = new PushDemo();
        PopDemo popOperation = new PopDemo();
        IsEmptyDemo isEmptyOperation = new IsEmptyDemo();
        PeekDemo peekOperation = new PeekDemo();
        // Kiểm tra các chức năng
        System.out.println("StackDemo created successfully!");
        pushOperation.push(stack, 10);
        pushOperation.push(stack, 20);
        pushOperation.push(stack, 30);

        System.out.println("Top element is: " + peekOperation.peek(stack));
        popOperation.pop(stack);
        popOperation.pop(stack);
        System.out.println("Is stack empty? " + isEmptyOperation.isEmpty(stack));
        popOperation.pop(stack);
        System.out.println("Is stack empty? " + isEmptyOperation.isEmpty(stack));
    }
}