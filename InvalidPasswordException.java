package sample;

import javax.swing.*;

public class InvalidPasswordException extends Exception{
    public InvalidPasswordException(String msg){
        super(msg);
    }

    public InvalidPasswordException( ){
        //super("Wrong Password. Please try again");
        JOptionPane.showMessageDialog(null,"Incorrect Password");
    }
}
