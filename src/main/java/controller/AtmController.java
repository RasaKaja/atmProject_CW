package controller;

import dto.User;
import dto.UserCard;

import javax.swing.*;
import java.util.Date;

public class AtmController {

    public BankController bankController;

    private UserCard activeCard;
    private boolean isValidated = false;

    public AtmController() {
    }

    // another constructor for accepting the bank

    public AtmController(UserCard activeCard) {
        this.activeCard = activeCard;
    }

    public void insertCard(UserCard userCard){
        this.activeCard = userCard;
    }

    public String validateCard(int cardPin){

        try {
            this.isValidated = this.activeCard.isPinValid(cardPin);
            if (!this.isValidated) return "Invalid PIN!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }

        return "Card validated successfully";
    }

    public void setBankController(BankController bankController) {
        this.bankController = bankController;
    }

    public String deposit(Double amountToDeposit){
        if (!isValidated) return "Please validate your card.";
        this.activeCard.setBalance(this.activeCard.getBalance() + amountToDeposit);

        return "Deposit successful, new balance is: " + this.activeCard.getBalance();
    }

    public String withdraw(Double amountToWithdraw){
        if (!isValidated) return "Please validate your card.";

        double currentBalance = this.activeCard.getBalance();
        if (currentBalance < amountToWithdraw) return "Not enough balance";

        this.activeCard.setBalance(currentBalance - amountToWithdraw);

        return "Withdraw successful, new balance " + this.activeCard.getBalance();
    }

    public String getUserBalance(){
        if (!isValidated) return "Please validate your card";
        return "Your current balance is " + this.activeCard.getBalance();
    }

    public String removeCard(){
        this.activeCard = null;
        this.isValidated = false;

        return "Card removed. Good bye!";
    }
}
