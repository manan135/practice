package Splitwise.Service;

import Splitwise.Data.BalanceSheet;
import Splitwise.Data.Operations;
import Splitwise.Data.SplitType;
import Splitwise.Data.UsersData;
import Splitwise.Model.User;
import Splitwise.Service.EqualSplit;
import Splitwise.Service.ExactSplit;
import Splitwise.Service.Expense;
import Splitwise.Service.PercentSplit;

import java.util.*;
//import lo
import java.util.Objects;
public class Operation {

    public boolean process(String entry) {
        String[] input = entry.split(" ");
        if (isValidInput(input)) {
            if (Objects.equals(input[0], Operations.EXPENSE.name())) {
                postExpenses(input);
            } else if (Objects.equals(input[0], Operations.SHOW.name())) {
                showBalances(input);
            }
        } else {
            return false;
        }
        return true;
    }

    private void showBalances(String[] input) {
        BalanceSheet.showBalanceSheet(input);
    }

    private void postExpenses(String[] input) {
        int inputSize = input.length;
        ArrayList<Double> splitFactors = new ArrayList<>();
//        owed = UsersData.users.get(input[1]);
//        totalAmount = Double.parseDouble(input[2]);
        Expense expense = null;
        ArrayList<User> owesUsers = new ArrayList<>();
        int numOfOwesUsers = Integer.parseInt(input[3]);
        int i = 4;
        while(i<4+numOfOwesUsers){
            owesUsers.add(UsersData.users.get(input[i]));
            i++;
        }

        String splitType = input[i];
        i++;
        while(i<inputSize && !Objects.equals(splitType, "EQUAL")) {
            splitFactors.add(Double.parseDouble(input[i]));
            i++;
        }

        switch (splitType){
            case ("EQUAL"):
                expense = new EqualSplit(UsersData.users.get(input[1]),Double.parseDouble(input[2]),owesUsers);
                break;
            case ("EXACT"):
                expense = new ExactSplit(UsersData.users.get(input[1]),Double.parseDouble(input[2]),owesUsers,splitFactors);
                break;
            case ("PERCENT"):
                expense = new PercentSplit(UsersData.users.get(input[1]),Double.parseDouble(input[2]),owesUsers, splitFactors);
        }
        if(expense != null)
            expense.calculate();
    }

    private boolean isValidInput(String[] entry) {
        return true;
    }
}
