package Splitwise.Service;

import Splitwise.Model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class PercentSplit extends Expense {
    ArrayList<Double> owedPercent = new ArrayList<>();

    public PercentSplit(User owed, double totalAmount, ArrayList<User> owesUsers, ArrayList<Double> owedPercent) {
        super(owed, totalAmount, owesUsers);
        this.owedPercent = owedPercent;
    }

    @Override
    public void calculate() {
        HashMap<User, Double> amountOwedPerUser = new HashMap<>();
        if (isValid()) {
            for (int i = 0; i < owesUsers.size(); i++) {
                if(owesUsers.get(i) != owed)
                    amountOwedPerUser.put(owesUsers.get(i), (totalAmount * owedPercent.get(i) / 100));
            }
            super.updateBalanceSheet(amountOwedPerUser);
        }
    }

    private boolean isValid(){
        return 100 == owedPercent.stream().mapToDouble(p-> p).sum();
    }
}
