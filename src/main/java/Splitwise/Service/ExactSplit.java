package Splitwise.Service;

import Splitwise.Model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class ExactSplit extends Expense {
    ArrayList<Double> owedAmounts = new ArrayList<>();

    public ExactSplit(User owed, double totalAmount, ArrayList<User> owesUsers, ArrayList<Double> owedAmounts) {
        super(owed, totalAmount, owesUsers);
        this.owedAmounts = owedAmounts;
    }

    @Override
    public void calculate() {
        HashMap<User, Double> amountOwedPerUser = new HashMap<>();
        if (isValid()) {
            for (int i = 0; i < owesUsers.size(); i++) {
               if(owesUsers.get(i) != owed)
                amountOwedPerUser.put(owesUsers.get(i), owedAmounts.get(i));
            }
            super.updateBalanceSheet(amountOwedPerUser);
        }
    }

    private boolean isValid() {
        return totalAmount == owedAmounts.stream().mapToDouble(p -> p).sum();
    }
}
