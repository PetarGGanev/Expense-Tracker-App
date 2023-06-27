package ExpenseTrackerApp;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTrackerApp {
    private List<Double> expenses;

    public ExpenseTrackerApp() {
        expenses = new ArrayList<>();
    }

    public void addExpense(double amount) {
        expenses.add(amount);
    }

    public double calculateTotalExpense() {
        double totalExpense = 0;
        for (double expense : expenses) {
            totalExpense += expense;
        }
        return totalExpense;
    }
}
