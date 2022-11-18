package Splitwise.Data;

import Splitwise.Model.User;

import java.util.HashMap;

public class BalanceSheet {
    //    private static ArrayList<ArrayList<Float>> balances = new ArrayList<>();
    private static HashMap<User, HashMap<User, Double>> balanceSheet = new HashMap<>();

    public static HashMap<User, HashMap<User, Double>> getBalances() {
        return balanceSheet;
    }

    public static HashMap<User, HashMap<User, Double>> getBalances(User user) {
        HashMap<User, HashMap<User, Double>> reqMap = new HashMap<>();
        reqMap.put(user, balanceSheet.get(user));
        return reqMap;
    }

    public static void setBalances(User owedUser, HashMap<User, Double> owedBalances) {
        if (balanceSheet.containsKey(owedUser)) {
            HashMap<User, Double> existingBalances = balanceSheet.get(owedUser);
            owedBalances.forEach((user, amount) -> {
                existingBalances.put(user, existingBalances.getOrDefault(user, 0.0) + amount);
            });
        } else {
            balanceSheet.put(owedUser, owedBalances);
        }
    }

    public static void showBalanceSheet(String[] input){
        boolean showOwes = !(input.length == 1);
        HashMap<User, HashMap<User, Double>> balances;
        if (!showOwes) {
            balances = BalanceSheet.getBalances();
        } else {
            balances = BalanceSheet.getBalances((UsersData.users.get(input[1])));
        }

        balances.forEach((owedUser, owes) -> {
            owes.forEach((owesUser, owesBalance) -> {
                if (!(!showOwes && owesBalance < 0)) {
                    if (owesBalance < 0) {
                        System.out.println(owedUser.getName() + " owes " + owesUser.getName() + ": " + Math.abs(owesBalance));
                    } else if (owesBalance > 0) {
                        System.out.println(owesUser.getName() + " owes " + owedUser.getName() + ": " + owesBalance);
                    }
                }
            });
        });
    }
}
