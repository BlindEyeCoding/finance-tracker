import java.util.Scanner;

public class Main {

    static double balance = 0;
    static boolean running = true;

    static void main() {

        Scanner scanner = new Scanner(System.in);

        while (running) {

            System.out.println("=== Personal Finance Tracker ===");
            System.out.println("Choose an option");
            System.out.println("1. Add income");
            System.out.println("2. Add expense");
            System.out.println("3. View balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addIncome(scanner);
                    break;
                case 2:
                    addExpense(scanner);
                    break;
                case 3:
                    showBalance();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    invalidOption();
                    break;

            }
        }
    }

    static void addIncome(java.util.Scanner scanner) {
        System.out.println("Add income amount");
        double income = scanner.nextDouble();
        balance += income;
        System.out.println("Income added successfully");
    }
    static void addExpense(java.util.Scanner scanner) {
        System.out.println("Add expense amount");
        double expense = scanner.nextDouble();
        balance -= expense;
        System.out.println("Expense added successfully");
    }
    static void showBalance() {
        System.out.println("Available balance $" + balance);
    }
    static void exit() {
        System.out.println("Goodbye");
        running = false;
    }
    static void invalidOption() {
        System.out.println("Invalid Option");
    }
}
