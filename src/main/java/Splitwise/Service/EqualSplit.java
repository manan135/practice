package Splitwise.Service;

import Splitwise.Model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class EqualSplit extends Expense {
    public EqualSplit(User owed, double totalAmount, ArrayList<User> owesUsers) {
        super(owed, totalAmount, owesUsers);
    }

    @Override
    public void calculate() {
        double amountOwedByEachUser = totalAmount / owesUsers.size();
        HashMap<User, Double> amountOwedPerUser = new HashMap<>();
        owesUsers.forEach(user -> {
            if (user != owed)
                amountOwedPerUser.put(user, amountOwedByEachUser);
        });
        super.updateBalanceSheet(amountOwedPerUser);
    }
}
