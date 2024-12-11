public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng BankAccount mới
        BankAccount account = new BankAccount("John Doe", 1000.00);

        // Truy cập số dư qua phương thức getter
        System.out.println("Chủ tài khoản: " + account.getAccountHolder());
        System.out.println("Số dư ban đầu: $" + account.getBalance());

        // Nạp tiền vào tài khoản qua phương thức setter
        account.deposit(500.00);
        System.out.println("Sau khi nạp, số dư: $" + account.getBalance());

        // Rút tiền từ tài khoản qua phương thức setter
        account.withdraw(200.00);
        System.out.println("Sau khi rút, số dư: $" + account.getBalance());

        // Thử rút số tiền không hợp lệ
        account.withdraw(2000.00);
    }
}