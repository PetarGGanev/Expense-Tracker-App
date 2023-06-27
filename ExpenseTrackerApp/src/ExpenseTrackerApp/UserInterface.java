package ExpenseTrackerApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
    private ExpenseTrackerApp expenseTracker;
    private JFrame frame;
    private JLabel expenseLabel;

    public UserInterface(ExpenseTrackerApp expenseTracker) {
        this.expenseTracker = expenseTracker;
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Expense Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("Expense Tracker");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(titleLabel);

        JButton addButton = new JButton("Add Expense");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(frame, "Enter the expense amount:");
                if (input != null && !input.isEmpty()) {
                    try {
                        double amount = Double.parseDouble(input);
                        expenseTracker.addExpense(amount);
                        updateExpenseLabel();
                        JOptionPane.showMessageDialog(frame, "Expense added successfully!");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid amount.");
                    }
                }
            }
        });
        frame.add(addButton);

        expenseLabel = new JLabel("Total expense: $0.00");
        expenseLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        frame.add(expenseLabel);

        frame.setVisible(true);
    }

    private void updateExpenseLabel() {
        double totalExpense = expenseTracker.calculateTotalExpense();
        expenseLabel.setText("Total expense: $" + String.format("%.2f", totalExpense));
    }

    public void start() {
        // No need to add code here for this example
    }
}
