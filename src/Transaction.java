public class Transaction {

    double amount;
    String type;
    String category;
    String description;

    public Transaction(double amount, String type, String category, String description) {

        this.amount = amount;
        this.type = type;
        this.category = category;
        this.description = description;
    }
}
