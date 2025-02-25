
package projectg2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame {
    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subButton, mulButton, divButton;

    public Calculator() {
        setTitle("Máy tính đơn giản");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Số thứ nhất:"));
        num1Field = new JTextField();
        add(num1Field);

        add(new JLabel("Số thứ hai:"));
        num2Field = new JTextField();
        add(num2Field);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");

        addButton.addActionListener(e -> calculateAddition());
        subButton.addActionListener(e -> calculateSubtraction());
        mulButton.addActionListener(e -> calculateMultiplication());
        divButton.addActionListener(e -> calculateDivision());

        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);

        add(new JLabel("Kết quả:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);
    }

    private void calculateAddition() {
       
    }

    private void calculateSubtraction() {
        performCalculation((a, b) -> a - b);
    }

    private void calculateMultiplication() {
        
    }

    private void calculateDivision() {
        
    }

    private void performCalculation(CalculatorFunction function) {
        performCalculation(function, "Vui lòng nhập số hợp lệ");
    }

    private void performCalculation(CalculatorFunction function, String errorMessage) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = function.apply(num1, num2);
            resultField.setText(Double.isNaN(result) ? errorMessage : String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText(errorMessage);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculator().setVisible(true);
        });
    }
}

@FunctionalInterface
interface CalculatorFunction {
    double apply(double a, double b);
}
