package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Withdraw {
    @FXML
    public TextField acNum;
    @FXML
    public TextField wAmount;
    @FXML
    public TextField pass;
    @FXML
    public TextArea information;
    public void enter(ActionEvent event) throws InsufficientBalanceException, InvalidPasswordException {
        try{
            String acn = acNum.getText();
            double amount = Double.parseDouble(wAmount.getText());
            String pWord = pass.getText();
            Main.info.withdraw(acn,amount,pWord);
            BankAccount inf = Main.info.display(acn,pWord);
            information.setText((inf+" "));
            pass.setText("");
        }catch(InsufficientBalanceException | InvalidPasswordException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void checkBalance(ActionEvent event) throws InvalidPasswordException{
        try{
            String acn = acNum.getText();
            String pWord = pass.getText();
            BankAccount inf = Main.info.display(acn,pWord);
            information.setText((inf+" "));
        }catch (InvalidPasswordException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void exit(ActionEvent event) throws IOException
    {
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        s.hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Fill up Withdraw Form");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
