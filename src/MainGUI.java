import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainGUI extends Application {

    TransactionManager manager = new TransactionManager();
    TableView<Transaction> table = new TableView<>();

    @Override
    public void start(Stage stage) {

        Label resultLabel = new Label();
        TextField amountField = new TextField();
        Button incomeBtn = new Button("Add Income");
        Button expenseBtn = new Button("Add Expense");
        Label balanceLabel = new Label("Balance: $0");

        // Income Button
        incomeBtn.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                manager.addIncomeFromGUI(amount);
                table.getItems().setAll(manager.getTransactions());
                resultLabel.setText("Income added: $" + amount);
                balanceLabel.setText("Balance: $" + manager.getBalance());
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number");
                amountField.clear();
            }
        });

        // Expense Button
        expenseBtn.setOnAction(e -> {
            double amount = Double.parseDouble(amountField.getText());
            manager.addExpenseFromGUI(amount);
            table.getItems().setAll(manager.getTransactions());
            resultLabel.setText("Expense added: $" + amount);
            balanceLabel.setText("Balance: $" + manager.getBalance());
        });

        // Table Config
        TableColumn<Transaction, String> typeCol = new TableColumn<>("Type");
        TableColumn<Transaction, Double> amountCol = new TableColumn<>("Amount");

        typeCol.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().type)
        );

        amountCol.setCellValueFactory(data ->
                new javafx.beans.property.SimpleObjectProperty<>(data.getValue().amount)
        );

        table.getColumns().addAll(typeCol, amountCol);



        VBox root = new VBox();
        root.getChildren().addAll(amountField, incomeBtn, resultLabel, balanceLabel);
        root.getChildren().add(expenseBtn);
        root.getChildren().add(table);

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}