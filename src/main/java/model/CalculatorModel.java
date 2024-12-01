package model;

public class CalculatorModel {
    private double result = 0;
    private String operator = "";
    private final StringBuilder strNumber = new StringBuilder();

    public void clear() {
        strNumber.setLength(0);
        result = 0;
        operator = "";
    }

    public void deleteLastCharacter() {
        if (!strNumber.isEmpty()) {
            strNumber.deleteCharAt(strNumber.length() - 1);
        }
    }

    public void toggleSign() {
        if (!strNumber.isEmpty()) {
            double value = Double.parseDouble(strNumber.toString());
            value = -value;
            strNumber.setLength(0);
            strNumber.append(value);
        }
    }

    public void appendNumber(String number) {
        strNumber.append(number);
    }

    public void appendDot() {
        if (!strNumber.toString().contains(".")) {
            if (strNumber.isEmpty()) {
                strNumber.append("0");
            }
            strNumber.append(".");
        }
    }

    public void setOperator(String command) {
        operator = command;
    }

    public String getCurrentInput() {
        return strNumber.toString();
    }

    public double getResult() {
        return result;
    }

    public void calculate() {
        if (strNumber.isEmpty()) return;

        double currentValue = Double.parseDouble(strNumber.toString());

        result = switch (operator) {
            case "+" -> result + currentValue;
            case "-" -> result - currentValue;
            case "*" -> result * currentValue;
            case "/" -> {
                if (currentValue != 0) {
                    yield result / currentValue;
                } else {
                    throw new ArithmeticException("Cannot divide by zero");
                }
            }
            case "%" -> result % currentValue;
            default -> currentValue;
        };
        
        strNumber.setLength(0); // Reset current input after calculation
        operator = ""; // Reset operator for next calculation
    }

    public boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
