package Pr20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class RPNCalculatorGUI extends JFrame {
    private JTextField inputField;
    private JTextField resultField;

    public RPNCalculatorGUI() {
        setTitle("RPN Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        inputField = new JTextField(20);
        resultField = new JTextField(20);
        resultField.setEditable(false);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                double result = calculateRPN(input);
                resultField.setText("Result: " + result);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(inputField);
        panel.add(calculateButton);
        panel.add(resultField);

        add(panel);
    }

    public static double calculateRPN(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                // Если токен является числом, помещаем его в стек
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                // Если токен является оператором, выполняем операцию над двумя верхними числами в стеке
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(token, operand1, operand2);
                stack.push(result);
            } else {
                throw new IllegalArgumentException("Недопустимый токен: " + token);
            }
        }

        // Результат находится на вершине стека
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static double performOperation(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Деление на ноль!");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Недопустимый оператор: " + operator);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RPNCalculatorGUI calculator = new RPNCalculatorGUI();
                calculator.setVisible(true);
            }
        });
    }
}

