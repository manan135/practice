package Splitwise;

import Splitwise.Data.UsersData;
import Splitwise.Model.User;
import Splitwise.Service.Operation;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        createUsers();
        Operation operation = new Operation();
        while (true) {
            System.out.println("Enter expense details:");
            Scanner input = new Scanner(System.in);
            String in = input.nextLine();
            if(Objects.equals(in, "DONE"))
                break;
//        String in = input.nextLine();
            if (operation.process(in))
                System.out.println("Operation successful");
            else
                System.out.println("Invalid input");
        }
        System.out.println("Bye! See you again later!!");
    }

    private static void createUsers() {
        User user1 = new User("Manan", "manan@java.com", "9887456218");
        User user2 = new User("Shweta", "shweta@java.com", "9887456218");
        User user3 = new User("Nipun", "nipun@java.com", "9887456218");
        UsersData.users.put(user1.getUserid(), user1);
        UsersData.users.put(user2.getUserid(), user2);
        UsersData.users.put(user3.getUserid(), user3);
    }
}
