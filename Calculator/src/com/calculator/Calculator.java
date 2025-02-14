package com.calculator;

import javax.swing.*;

public class Calculator {
    public JPanel framePanel;
    private JTextField displayArea;
    private JButton buttonNumber1, buttonNumber2, buttonNumber3, buttonDivision;
    private JButton buttonNumber4, buttonNumber5, buttonNumber6, buttonMultiple;
    private JButton buttonNumber7, buttonNumber8, buttonNumber9, buttonSubtraction;
    private JButton clearButton, buttonNumber0, decimalButton, equalButton
    , buttonAddition;

    private double leftOperant = 0, rightOperant = 0, result = 0;
    private String operator = "";
    private boolean isNewNumber = true;

    public Calculator() {
        buttonNumber1.addActionListener(e -> appendNumber("1"));
        buttonNumber2.addActionListener(e -> appendNumber("2"));
        buttonNumber3.addActionListener(e -> appendNumber("3"));
        buttonNumber4.addActionListener(e -> appendNumber("4"));
        buttonNumber5.addActionListener(e -> appendNumber("5"));
        buttonNumber6.addActionListener(e -> appendNumber("6"));
        buttonNumber7.addActionListener(e -> appendNumber("7"));
        buttonNumber8.addActionListener(e -> appendNumber("8"));
        buttonNumber9.addActionListener(e -> appendNumber("9"));
        buttonNumber0.addActionListener(e -> appendNumber("0"));

        // Operator Buttons
        buttonAddition.addActionListener(e -> selectOperator("+"));
        buttonSubtraction.addActionListener(e -> selectOperator("-"));
        buttonMultiple.addActionListener(e -> selectOperator("*"));
        buttonDivision.addActionListener(e -> selectOperator("/"));

        // Function Buttons
        equalButton.addActionListener(e -> calculate());
        clearButton.addActionListener(e -> clear());
        decimalButton.addActionListener(e -> addDecimal());
    }

    private void appendNumber(String number) {
        if (isNewNumber) {
            displayArea.setText(number);
            isNewNumber = false;
        } else {
            displayArea.setText(displayArea.getText() + number);
        }
    }

    private void selectOperator(String op) {
        leftOperant = Double.parseDouble(displayArea.getText());
        operator = op;
        isNewNumber = true;
    }

    private void calculate() {
        rightOperant = Double.parseDouble(displayArea.getText());

        switch (operator) {
            case "+" -> result = leftOperant + rightOperant;
            case "-" -> result = leftOperant - rightOperant;
            case "*" -> result = leftOperant * rightOperant;
            case "/" -> result = (rightOperant != 0) ? leftOperant / rightOperant : 0;
            default -> {
                return;
            }
        }

        displayArea.setText(String.valueOf(result));
        isNewNumber = true;
    }

    private void clear() {
        displayArea.setText("");
        leftOperant = rightOperant = result = 0;
        operator = "";
        isNewNumber = true;
    }

    private void addDecimal() {
        if (!displayArea.getText().contains(".")) {
            displayArea.setText(displayArea.getText() + ".");
        }
    }
}