import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static double balance = 0;
    static boolean running = true;
    static ArrayList<Transaction> transactions = new ArrayList<>();

    static void main() {

        Scanner scanner = new Scanner(System.in);

        while (running) {

            System.out.println("=== Personal Finance Tracker ===");
            System.out.println("Choose an option");
            System.out.println("1. Add income");
            System.out.println("2. Add expense");
            System.out.println("3. View balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");

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
                    showTransactions();
                    break;
                case 5:
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

        scanner.nextLine();

        System.out.println("Category:");
        String category = scanner.nextLine();

        System.out.println("Description:");
        String description = scanner.nextLine();

        balance += income;

        transactions.add(new Transaction(income, "Income", category, description));

        System.out.println("Income added successfully");
    }
    static void addExpense(java.util.Scanner scanner) {
        System.out.println("Add expense amount");
        double expense = scanner.nextDouble();

        scanner.nextLine();

        System.out.println("Category:");
        String category = scanner.nextLine();

        System.out.println("Description:");
        String description = scanner.nextLine();

        balance -= expense;

        transactions.add(new Transaction(expense, "Expense", category, description));

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
    static void showTransactions() {

        System.out.println("=== Transaction History ===");

        for (Transaction t : transactions) {

            System.out.println(
                    t.type + " | $" + t.amount +
                            " | " + t.category +
                            " | " + t.description
            );
        }
    }
}
