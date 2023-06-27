package ExpenseTrackerApp;

public class Main {
    public static void main(String[] args) {
        ExpenseTrackerApp expenseTracker = new ExpenseTrackerApp();
        UserInterface ui = new UserInterface(expenseTracker);
        ui.start();
    }
}
