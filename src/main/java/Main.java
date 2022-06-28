import controller.AtmController;
import controller.BankController;
import controller.MenuController;
import dto.User;
import dto.UserCard;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        MenuController menuController = new MenuController();
        menuController.start();

//        BankController bankController = new BankController();
//
//        Date expiryDate = new Date(2022, Calendar.JUNE, 22);
////        try {
////            expiryDate = new SimpleDateFormat("yyyy-mm-dd").parse("2022-06-22");
////        } catch (Exception ee) {
////            System.out.println(ex);;
////        }
//
//        UserCard card = new UserCard(expiryDate, 1245.50d, 2022);
//        User user1 = new User("Rasa", "123456789", card, 2.15);
//
//        bankController.createUser(user1);
//
//        AtmController atmController = new AtmController();
//        atmController.setBankController(bankController);
//        atmController.insertCard(user1.getCard());
//
//        JOptionPane.showMessageDialog(null, atmController.deposit());
//        JOptionPane.showMessageDialog(null, atmController.withdraw());
//
//        JOptionPane.showMessageDialog(null, atmController.validateCard()); // parentComponent: is it in separate open window, GUI window, some background thing
//
//        JOptionPane.showMessageDialog(null, atmController.deposit());
//        JOptionPane.showMessageDialog(null, atmController.withdraw());
//        JOptionPane.showMessageDialog(null, atmController.removeCard());
//
//        JOptionPane.showMessageDialog(null, atmController.withdraw());
    }
}
