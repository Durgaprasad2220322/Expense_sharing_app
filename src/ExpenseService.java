package src;

import java.util.HashMap;
import java.util.Map;

public class ExpenseService{

    // balances[A][B] = X means A owes B amount X
    private Map<User, Map<User, Double>> balances = new HashMap<>();

    public void addExpense(Expense expense){
        User paidBy = expense.getPaidBy();

        for (Split split : expense.getSplits()){
            User user = split.getUser();
            double amount = split.getAmount();

            // Skip if the payer is the same user
            if (user.equals(paidBy)){
                continue;
            }

            addBalance(user, paidBy, amount);
        }
    }

    private void addBalance(User fromUser, User toUser, double amount){
        balances
            .computeIfAbsent(fromUser, k -> new HashMap<>())
            .merge(toUser, amount, Double::sum);

        simplifyBalance(fromUser, toUser);
    }

    private void simplifyBalance(User user1, User user2){
        Double u1_Owes_U2 = balances
                .getOrDefault(user1, new HashMap<>())
                .get(user2);

        Double u2_Owes_U1 = balances
                .getOrDefault(user2, new HashMap<>())
                .get(user1);

        if (u1_Owes_U2 != null && u2_Owes_U1 != null){
            if (u1_Owes_U2 > u2_Owes_U1) {
                balances.get(user1).put(user2, u1_Owes_U2 - u2_Owes_U1);
                balances.get(user2).remove(user1);
            } else if (u2_Owes_U1 > u1_Owes_U2){
                balances.get(user2).put(user1, u2_Owes_U1 - u1_Owes_U2);
                balances.get(user1).remove(user2);
            } else {
                balances.get(user1).remove(user2);
                balances.get(user2).remove(user1);
            }
        }
    }

    public Map<User, Map<User, Double>> getBalances(){
        return balances;
    }
}

