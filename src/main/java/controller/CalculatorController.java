package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField mainTextField;
    @FXML
    private TextField historyTextField;

    private final StringBuilder input = new StringBuilder();
    private double result = 0;
    private String operator = "";

    @FXML
    private void initialize() {
        mainTextField.setEditable(false);
        historyTextField.setEditable(false);
    }

    @FXML
    private void handleButtonAction(javafx.event.ActionEvent event) {
        String command = ((javafx.scene.control.Button) event.getSource()).getText();

        switch (command) {
            case "C":
                clear();
                break;
            case "=":
                calculate();
                break;
            case "Del":
                deleteLastCharacter();
                break;
            case "-/+":
                toggleSign();
                break;
            case ".":
                handleDotInput();
                break;
            default:
                if (isNumeric(command)) {
                    handleNumberInput(command);
                } else {
                    handleInput(command);
                }
                break;
        }
    }

    private void clear() {
        input.setLength(0);
        mainTextField.setText("");
        result = 0;
        operator = "";
    }

    private void deleteLastCharacter() {
        if (!input.isEmpty()) {
            input.deleteCharAt(input.length() - 1);
            mainTextField.setText(input.toString());
        }
    }

    private void toggleSign() {
        if (!input.isEmpty()) {
            double value = Double.parseDouble(input.toString());
            value = -value;
            input.setLength(0);
            input.append(value);
            mainTextField.setText(input.toString());
        }
    }

    private void handleDotInput() {
        if (!input.toString().contains(".")) {
            if (input.isEmpty()) {
                input.append("0");
            }
            input.append(".");
            mainTextField.setText(input.toString());
        }
    }

    private void handleNumberInput(String number) {
        input.append(number);
        mainTextField.setText(input.toString());
    }

    private void handleInput(String command) {
        if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/") || command.equals("%")) {
            if (!input.isEmpty()) {
                calculate();
            }
            operator = command;
            input.setLength(0);
        }
    }

    private void calculate() {
        if (input.isEmpty()) return;

        double currentValue = Double.parseDouble(input.toString());

        switch (operator) {
            case "+":
                result += currentValue;
                break;
            case "-":
                result -= currentValue;
                break;
            case "*":
                result *= currentValue;
                break;
            case "/":
                if (currentValue != 0) {
                    result /= currentValue;
                } else {
                    mainTextField.setText("Error");
                    clear();
                    return;
                }
                break;
            case "%":
                result %= currentValue;
                break;
            default:
                result = currentValue;
                break;
        }

        input.setLength(0);
        mainTextField.setText(String.valueOf(result));
        operator = ""; // Reset operator for next operation
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}