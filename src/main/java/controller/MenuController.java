package controller;

import dto.User;
import dto.UserCard;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class MenuController {

    private final AtmController atmController = new AtmController();

    public MenuController(){
        this.atmController.setBankController(new BankController());
    }

    public MenuController(BankController bankController){
        this.atmController.setBankController(bankController);
    }

    public void start(){
        this.displayMainMenu();
    }

    private void displayMainMenu() {
        JOptionPane.showConfirmDialog(null,
                "Welcome to the ATM. Please choose an option on the next prompt.");
        String option = JOptionPane.showInputDialog(null, """
                Write the corresponding number:
                1. Insert Card
                2. Withdraw
                3. Deposit
                4. See Balance
                5. Remove Card
                6. Create Account
                7. Close / Exit
                """);

        switch (option){
            case "1" :
                this.handleCardInsertion();
                break;
            case "2":
                this.handleWithdraw();
                break;
            case "3":
                this.handleDeposit();
                break;
            case "4":
                this.displayUserBalance();
                break;
            case "5":
                this.handleRemoveCard();
                break;
            case "6":
                this.handleAccountCreation();
                break;
            case "7":
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "Please select valid entry.");
                break;
        }

        displayMainMenu(); //recursion: method colling itself
    }

    private void handleRemoveCard() {
        JOptionPane.showMessageDialog(null, this.atmController.removeCard());
    }

    private void displayUserBalance() {
        JOptionPane.showMessageDialog(null, this.atmController.getUserBalance());
    }

    private void handleDeposit() {
        Double amountToDeposit = Double.parseDouble(JOptionPane.showInputDialog("Enter amount yu want to deposit: "));
        JOptionPane.showMessageDialog(null, this.atmController.deposit(amountToDeposit));
    }

    private void handleWithdraw() {
        Double amountToWithdraw = Double.parseDouble(JOptionPane.showInputDialog("Enter amount you want to withdraw: "));
        JOptionPane.showMessageDialog(null, this.atmController.withdraw(amountToWithdraw));
    }

    private void handleAccountCreation() {
        String name = JOptionPane.showInputDialog(null, "Enter your name");
        String cardPin = JOptionPane.showInputDialog(null, "Choose your card Pin");
        Date expiryDate = new Date(2022, Calendar.JUNE, 22);

        UserCard userCard = new UserCard(expiryDate, 0.00d, Integer.parseInt(cardPin));
        User user = new User(name, userCard, 2.5);

        this.atmController.bankController.createUser(user);
        JOptionPane.showMessageDialog(null, "User account number is " + user.getAccountNumber());
    }

    private void handleCardInsertion() {
        String accountName =JOptionPane.showInputDialog(null, "Enter your account number.");
        String pin =JOptionPane.showInputDialog(null, "Enter your pin.");

        try {
            User user = atmController.bankController.findUserByAccountNumber(accountName);
            atmController.insertCard(user.getCard());
            atmController.validateCard(Integer.parseInt(pin));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
