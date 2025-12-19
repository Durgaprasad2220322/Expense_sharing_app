package src;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        User ayaan = new User("U1", "Ayaan");
        User arha = new User("U2", "Arha");
        User james = new User("U3", "James");
        Group group = new Group(
                "G1",
                "Colleague Trip",
                Arrays.asList(ayaan, arha, james)
        );
        ExpenseService expenseService = new ExpenseService();
        Expense hotelExpense = new Expense(
                "E1",
                "Hotel Booking",
                6000,
                ayaan,
                Arrays.asList(
                        new Split(ayaan, 2000),
                        new Split(arha, 2000),
                        new Split(james, 2000)
                )
        );
        expenseService.addExpense(hotelExpense);
        Expense cabExpense = new Expense(
                "E2",
                "Cab Charges",
                900,
                arha,
                Arrays.asList(
                        new Split(ayaan, 300),
                        new Split(arha, 300),
                        new Split(james, 300)
                )
        );
        expenseService.addExpense(cabExpense);
        System.out.println("Final Balances:");
        expenseService.getBalances().forEach((fromUser, owesMap) -> {
            owesMap.forEach((toUser, amount) -> {
                System.out.println(
                        fromUser.getUname() + " owes " +
                        toUser.getUname() + " : " + amount
                );
            });
        });
    }
}
