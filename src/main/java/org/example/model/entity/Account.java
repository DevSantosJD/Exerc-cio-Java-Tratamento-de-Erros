package org.example.model.entity;

import org.example.model.exceptions.DepositException;
import org.example.model.exceptions.LimitException;
import org.example.model.exceptions.WithdrawException;

public class Account {

    private int number;
    private String hold;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String hold, Double balance, Double withdrawLimit) {
        this.number = number;
        this.hold = hold;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHold() {
        return hold;
    }

    public void setHold(String hold) {
        this.hold = hold;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount)throws DepositException{
        if(amount > 0){
            this.balance += amount;
        }
        else{
            throw new DepositException("Deposits allowed only for amounts above 0");
        }

    }

    public void withdraw(Double amount) throws LimitException, WithdrawException {
        if(amount > getWithdrawLimit()){
            throw new LimitException("The amount exceeds withdraw limit");
        }
        if(amount > getBalance()){
            throw new WithdrawException("Not enough balance");
        }
        this.balance -= amount;
    }

    @Override
    public String toString(){
        return "Number Account: "
                + getNumber()
                + "\nHolder: "
                + getHold()
                + "\nInitial Balance: "
                + getBalance()
                + "\nWithdraw Limit: "
                + getWithdrawLimit();
    }
}
