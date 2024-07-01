import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    exit();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Please choose an option: ");
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.printf("You have successfully deposited $%.2f. Your new balance is: $%.2f%n", amount, account.getBalance());
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.printf("You have successfully withdrawn $%.2f. Your new balance is: $%.2f%n", amount, account.getBalance());
        } else {
            System.out.println("Transaction failed. Please try again.");
        }
    }

    private void exit() {
        System.out.println("Thank you for using the ATM. Goodbye!");
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Initial balance
        ATM atm = new ATM(account);
        atm.start();
    }
}
