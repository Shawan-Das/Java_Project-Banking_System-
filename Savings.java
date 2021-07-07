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

public class Savings {
    @FXML
    public TextField name;
    @FXML
    public TextField amount;
    @FXML
    public TextField maxWithdraw;
    @FXML
    public TextField password;
    @FXML
    public TextField accountNumber;

    public void enter(ActionEvent event) {
                  String nm  = name.getText();
                  double amt = Double.parseDouble(amount.getText());
                  double maxAmt = Double.parseDouble(maxWithdraw.getText());
                  String pass = password.getText();

              String number = Main.info.addAccount(nm, amt, pass, maxAmt);
              accountNumber.setText(number + "");
              JOptionPane.showMessageDialog(null,
                      "Welcome to our Bank\nDon't Forget Your Password\nRemember Your Account Should Have Minimum 2000Tk");
              name.setText(""); amount.setText("");
    }

    public void back(ActionEvent event) throws IOException
    {
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        s.hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddAccount.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("WellCome to our Bank");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void exit(ActionEvent event) throws IOException
    {
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        s.hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Fill up Savings Account Form");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
