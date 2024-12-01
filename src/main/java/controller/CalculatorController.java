package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import model.CalculatorModel;

public class CalculatorController {

    @FXML
    private TextField mainTextField;
    @FXML
    private TextField historyTextField;

    private final CalculatorModel calculatorModel = new CalculatorModel();

    @FXML
    private void initialize() {
        mainTextField.setEditable(false);
        historyTextField.setEditable(false);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String buttonText = ((Button) event.getSource()).getText();

        switch (buttonText) {
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
                if (calculatorModel.isNumeric(buttonText)) {
                    handleNumberInput(buttonText);
                } else {
                    handleOperatorInput(buttonText);
                }
                break;
        }
    }

    private void clear() {
        calculatorModel.clear();
        mainTextField.setText("");
        historyTextField.setText("");
    }

    private void deleteLastCharacter() {
        calculatorModel.deleteLastCharacter();
        mainTextField.setText(calculatorModel.getCurrentInput());
    }

    private void toggleSign() {
        calculatorModel.toggleSign();
        mainTextField.setText(calculatorModel.getCurrentInput());
    }

    private void handleDotInput() {
        calculatorModel.appendDot();
        mainTextField.setText(calculatorModel.getCurrentInput());
    }

    private void handleNumberInput(String number) {
        calculatorModel.appendNumber(number);
        mainTextField.setText(calculatorModel.getCurrentInput());
    }

    private void handleOperatorInput(String command) {
        if (!calculatorModel.getCurrentInput().isEmpty()) {
            calculate();  // Perform any pending calculation
        }
        calculatorModel.setOperator(command);
        historyTextField.setText(String.valueOf(calculatorModel.getResult()) + " " + command);
    }

    private void calculate() {
        try {
            calculatorModel.calculate();
            mainTextField.setText(String.valueOf(calculatorModel.getResult()));
            historyTextField.setText("");
        } catch (ArithmeticException e) {
            mainTextField.setText("Error");
            clear();
        }
    }
}
