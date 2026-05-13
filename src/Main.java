import java.util.Scanner;

public class Main {

    static boolean running = true;

    static void main() {

        Scanner scanner = new Scanner(System.in);
        TransactionManager manager = new TransactionManager();
        manager.loadTransactions();


        while (running) {

            System.out.println("=== Personal Finance Tracker ===");
            System.out.println("Choose an option");
            System.out.println("1. Add income");
            System.out.println("2. Add expense");
            System.out.println("3. View balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");

            if (scanner.hasNextInt()) {

                int choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        manager.addIncome(scanner);
                        break;
                    case 2:
                        manager.addExpense(scanner);
                        break;
                    case 3:
                        manager.showBalance();
                        break;
                    case 4:
                        manager.showTransactions();
                        break;
                    case 5:
                        manager.saveTransactions();
                        System.out.println("Goodbye");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid Option");
                        break;

                }
            } else {

                System.out.println("Please enter a number");
                scanner.nextLine();
            }
        }
    }
}