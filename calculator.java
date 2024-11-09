import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    private Label displayLabel;
    private StringBuilder currentInput = new StringBuilder();
    private double firstOperand = 0;
    private String operator = "";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        // Display Label
        displayLabel = new Label("0");
        displayLabel.setStyle("-fx-font-size: 24px; -fx-alignment: center-right;");
        displayLabel.setMaxWidth(Double.MAX_VALUE);

        // Number and Operation Buttons
        GridPane gridPane = createButtons();

        // Layout Setup
        VBox root = new VBox(10, displayLabel, gridPane);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createButtons() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Number Buttons
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        int row = 0;
        int col = 0;
        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.setPrefSize(60, 60);
            button.setStyle("-fx-font-size: 18px;");
            button.setOnAction(e -> handleButtonClick(label));

            gridPane.add(button, col, row);
            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        return gridPane;
    }

    private void handleButtonClick(String label) {
        switch (label) {
            case "+":
            case "-":
            case "*":
            case "/":
                handleOperator(label);
                break;
            case "=":
                handleEquals();
                break;
            case ".":
                handleDecimalPoint();
                break;
            default: // Number
                handleNumber(label);
                break;
        }
    }

    private void handleOperator(String op) {
        if (currentInput.length() > 0) {
            firstOperand = Double.parseDouble(currentInput.toString());
            currentInput.setLength(0);
        }
        operator = op;
        displayLabel.setText(String.valueOf(firstOperand) + " " + operator);
    }

    private void handleEquals() {
        if (operator.isEmpty() || currentInput.length() == 0) return;

        double secondOperand = Double.parseDouble(currentInput.toString());
        double result = 0;

        switch (operator) {
            case "+": result = firstOperand + secondOperand; break;
            case "-": result = firstOperand - secondOperand; break;
            case "*": result = firstOperand * secondOperand; break;
            case "/":
                if (secondOperand == 0) {
                    displayLabel.setText("Error");
                    currentInput.setLength(0);
                    operator = "";
                    return;
                }
                result = firstOperand / secondOperand;
                break;
        }

        displayLabel.setText(String.valueOf(result));
        currentInput.setLength(0);
        operator = "";
    }

    private void handleDecimalPoint() {
        if (!currentInput.toString().contains(".")) {
            currentInput.append(".");
            displayLabel.setText(currentInput.toString());
        }
    }

    private void handleNumber(String number) {
        currentInput.append(number);
        displayLabel.setText(currentInput.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
