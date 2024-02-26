import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decimalButton, equalButton, delButton, clrButton;
    private JPanel panel;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public CalculatorApp() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 550);
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 25));
        textField.setEditable(false);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        functionButtons = new JButton[4];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;

        for (int i = 0; i < 4; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            functionButtons[i].setBackground(Color.WHITE);
            functionButtons[i].setFocusable(false);
        }

        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clear");

        decimalButton.addActionListener(this);
        equalButton.addActionListener(this);
        delButton.addActionListener(this);
        clrButton.addActionListener(this);

        decimalButton.setFont(new Font("Arial", Font.PLAIN, 20));
        equalButton.setFont(new Font("Arial", Font.PLAIN, 20));
        delButton.setFont(new Font("Arial", Font.PLAIN, 20));
        clrButton.setFont(new Font("Arial", Font.PLAIN, 20));

        decimalButton.setFocusable(false);
        equalButton.setFocusable(false);
        delButton.setFocusable(false);
        clrButton.setFocusable(false);

        decimalButton.setBackground(Color.WHITE);
        equalButton.setBackground(Color.WHITE);
        delButton.setBackground(Color.WHITE);
        clrButton.setBackground(Color.WHITE);

        decimalButton.setBounds(100, 400, 100, 50);
        equalButton.setBounds(250, 400, 100, 50);
        delButton.setBounds(300, 100, 100, 50);
        clrButton.setBounds(50, 100, 100, 50);

        panel.add(decimalButton);
        panel.add(equalButton);
        panel.add(delButton);
        panel.add(clrButton);

        panel.add(textField);
        panel.setBounds(0, 0, 420, 550);

        int xpos = 50, ypos = 100;
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) {
                xpos = 50;
                ypos += 60;
            }
            numberButtons[i].setBounds(xpos, ypos, 100, 50);
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.WHITE);
            xpos += 110;
            panel.add(numberButtons[i]);
        }

        for (int i = 0; i < 4; i++) {
            functionButtons[i].setBounds(300, 180 + i * 60, 100, 50);
            panel.add(functionButtons[i]);
        }

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }
        if (e.getSource() == decimalButton) {
            textField.setText(textField.getText() + ".");
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0)
                        result = num1 / num2;
                    else
                        textField.setText("Cannot divide by zero");
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String currentText = textField.getText();
            textField.setText(currentText.substring(0, currentText.length() - 1));
        }
    }
}
