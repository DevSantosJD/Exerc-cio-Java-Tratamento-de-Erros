package org.example;

import org.example.model.entity.Account;
import org.example.model.exceptions.DepositException;
import org.example.model.exceptions.LimitException;
import org.example.model.exceptions.WithdrawException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");

            sc.nextLine();

            String holder = sc.nextLine();
            System.out.print("Initial Balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw Limit: ");
            double withdrawLimit = sc.nextDouble();

            Account ac1 = new Account(number, holder, balance, withdrawLimit);

            System.out.println("\nConta criada com sucesso!");
            System.out.println();
            System.out.println("Dados Bancários:\n");
            System.out.println(ac1);

            System.out.print("\nEnter amount for withdraw: ");
            double saque = sc.nextDouble();


            ac1.withdraw(saque);
            System.out.println("New Balance: " + ac1.getBalance());

            System.out.println("Depositar: ");

            double deposit = sc.nextDouble();
            ac1.deposit(deposit);
            System.out.println("New Balance: " + ac1.getBalance());
        }
        catch (LimitException | WithdrawException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
        catch (DepositException e){
            System.out.println("Deposit error: " + e.getMessage());
        }
    }
}