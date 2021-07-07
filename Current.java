package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Current {
    @FXML
    public TextField name;
    @FXML
    public TextField amount;
    @FXML
    public TextField tradeLicense;
    @FXML
    public TextField password;
    @FXML
    public TextField accountNumber;
    @FXML
    public TextArea information;
    public void enter(ActionEvent event){
            String nm = name.getText();
            double amt = Double.parseDouble(amount.getText());
            String license = tradeLicense.getText();
            String pass = password.getText();
            String number = Main.info.addAccount(nm, amt, pass, license);
            accountNumber.setText(number + "");
            JOptionPane.showMessageDialog(null,
                    "Welcome to our Bank\nDon't Forget Your Password\nRemember, Your Account Should Have Minimum 5000Tk");

            tradeLicense.setText(""); amount.setText("");
        }

    public void cancel(ActionEvent event) throws IOException
    {
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        s.hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddAccount.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Fill up the form for Current Account");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void ok(ActionEvent event) throws IOException
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
