public class BankAccount {

    // Các trường dữ liệu riêng tư (dữ liệu bị ẩn)
    private double balance;
    private String accountHolder;

    // Constructor để khởi tạo đối tượng BankAccount
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Phương thức getter để lấy số dư tài khoản (truy cập công khai)
    public double getBalance() {
        return this.balance;
    }

    // Phương thức setter để nạp tiền vào tài khoản (truy cập công khai)
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Số tiền nạp phải lớn hơn 0.");
        }
    }

    // Phương thức rút tiền
    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.println("Số tiền rút không hợp lệ.");
        }
    }

    // Phương thức getter để lấy tên chủ tài khoản (truy cập công khai)
    public String getAccountHolder() {
        return this.accountHolder;
    }
}
