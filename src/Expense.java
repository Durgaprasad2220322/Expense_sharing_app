package src;
import java.util.List;

public class Expense{
    private String expenseId;
    private String description;
    private double amount;
    private User paidBy;
    private List<Split> splits;

    public Expense(String expenseId, String description, double amount,
                   User paidBy, List<Split> splits){
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
    }

    public String getExpenseId(){
        return expenseId;
    }

    public String getDescription(){
        return description;
    }

    public double getAmount(){
        return amount;
    }

    public User getPaidBy(){
        return paidBy;
    }

    public List<Split> getSplits(){
        return splits;
    }
}

