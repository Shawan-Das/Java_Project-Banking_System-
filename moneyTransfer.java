package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;

public class moneyTransfer {

    @FXML
    public TextField frstAccount;
    @FXML
    public TextField secAccount;
    @FXML
    public TextField amount;
    @FXML
    public TextField password;
    @FXML
    public TextArea information;
    public void enter(ActionEvent event){
        try{
            String from = frstAccount.getText();
            String to = secAccount.getText();
            double amt = Double.parseDouble(amount.getText());
            String pass = password.getText();
            BankAccount s1= Main.info.findAccount(from);
            BankAccount s2= Main.info.findAccount(to);
            if(s1 != null && s2!= null){
                Main.info.withdraw(from,amt,pass);
                Main.info.deposit(to,amt);
                JOptionPane.showMessageDialog(null,"Money Transfer Successful");
                BankAccount inf = Main.info.display(from,pass);
                amount.setText("");
                password.setText("");
            }
            else{
                JOptionPane.showMessageDialog(null,"Money Transfer Not Successful");
                amount.setText("");
                password.setText("");
            }
            BankAccount inf = Main.info.display(from,pass);
            information.setText(inf+"");
        }catch (InvalidPasswordException | InsufficientBalanceException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void checkBalance(ActionEvent event) throws InvalidPasswordException{
        try{
            String acn = frstAccount.getText();
            String pWord = password.getText();
            BankAccount inf = Main.info.display(acn,pWord);
            information.setText((inf+" "));
        }catch (InvalidPasswordException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void back(ActionEvent event) throws IOException
    {
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        s.hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("WellCome to our Bank");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
