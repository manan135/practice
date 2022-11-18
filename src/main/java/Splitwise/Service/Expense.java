package Splitwise.Service;

import Splitwise.Data.BalanceSheet;
import Splitwise.Data.SplitType;
import Splitwise.Data.UsersData;
import Splitwise.Model.User;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Expense {
    protected User owed;
    protected double totalAmount;
    protected ArrayList<User> owesUsers = new ArrayList<>();
    protected SplitType splitType;
    protected int splitFactors;

    public Expense(User owed, double totalAmount, ArrayList<User> owesUsers) {
        this.owed = owed;
        this.totalAmount = totalAmount;
        this.owesUsers = owesUsers;
    }

    public abstract void calculate();

    protected void updateBalanceSheet(HashMap<User,Double> amountOwedPerUser) {
        BalanceSheet.setBalances(owed,amountOwedPerUser);
    }
}
