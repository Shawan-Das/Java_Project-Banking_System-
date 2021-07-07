package sample;

import javax.swing.*;

public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String msg){
        super(msg);
    }

    public InsufficientBalanceException(double amt){
        JOptionPane.showMessageDialog(null,"Can't withdraw more than "+amt+" tk");
        //super("Can't withdraw more than " +amt+" tk.");
    }
}
