package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.MainModel;

public class MainController {

    private final MainModel mainModel = new MainModel();
    private boolean operationSet = false;

    @FXML
    private TextField mainTextField;

    @FXML
    private void initialize() {
        mainTextField.setEditable(false);
    }

    @FXML
    private void handleNumberAction(ActionEvent event) {
        String number = ((Button) event.getSource()).getText();

        if ("Error".equals(mainTextField.getText())) {
            mainTextField.clear();
        }

        mainTextField.appendText(number);
    }

    @FXML
    private void handleOperationAction(ActionEvent event) {
        String currentText = mainTextField.getText();
        if (!currentText.isEmpty() && !currentText.endsWith(" ")) {
            mainModel.setFirstNumber(Double.parseDouble(currentText));
            mainModel.setOperation(((Button) event.getSource()).getText());
            mainTextField.appendText(" " + mainModel.getOperation() + " ");
            operationSet = true;
        }
    }

    @FXML
    private void handleEqualsAction() {
        String currentText = mainTextField.getText();
        if (operationSet && currentText.contains(" ")) {
            String[] parts = currentText.split(" ");
            try {
                double result = Double.parseDouble(parts[0]);
                for (int i = 1; i < parts.length; i += 2) {
                    String operation = parts[i];
                    double nextNumber = Double.parseDouble(parts[i + 1]);
                    mainModel.setFirstNumber(result);
                    mainModel.setSecondNumber(nextNumber);
                    mainModel.setOperation(operation);
                    result = mainModel.calculate();
                }
                mainTextField.setText(currentText + " = " + result);
                operationSet = false;
            } catch (NumberFormatException e) {
                mainTextField.setText("Error");
            }
        }

        if (currentText.equals("12312005")) {
            mainTextField.setEditable(true);
            mainTextField.setAlignment(Pos.CENTER);
            mainTextField.setText("Who are you?!");
            System.out.println("Congratulations! You have found the secret number!");
        } else if (currentText.equals("John Rey Rabosa")) {
            mainTextField.setAlignment(Pos.CENTER);
            mainTextField.setText("WELCOME !!!");
            mainTextField.setEditable(false);
        }
    }

    @FXML
    private void handleDotAction() {
        String currentText = mainTextField.getText();
        if (currentText.isEmpty() || currentText.endsWith(" ")) {
            mainTextField.appendText("0.");
        } else if (!currentText.contains(".")) {
            mainTextField.appendText(".");
        }
    }

    @FXML
    private void handleClearAction() {
        mainTextField.clear();
        mainModel.reset();
        operationSet = false;
    }

    @FXML
    private void handleDeleteAction() {
        String currentText = mainTextField.getText();
        if (!currentText.isEmpty()) {
            mainTextField.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    @FXML
    private void handleToggleSignAction() {
        String currentText = mainTextField.getText();
        if (!currentText.isEmpty()) {
            String[] parts = currentText.split(" ");
            try {
                if (parts.length == 3) {
                    double value2 = Double.parseDouble(parts[2]);
                    value2 = -value2;
                    parts[2] = String.valueOf(value2);
                } else if (parts.length == 1) {
                    double value1 = Double.parseDouble(parts[0]);
                    value1 = -value1;
                    parts[0] = String.valueOf(value1);
                }
                mainTextField.setText(String.join(" ", parts));
            } catch (NumberFormatException e) {
                mainTextField.setText("Error");
            }
        }
    }
}