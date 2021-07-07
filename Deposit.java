package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Deposit {
    @FXML
   public TextField acNum;
    @FXML
    public TextField dAmount;

    public void enter(ActionEvent event){
        String acn = (acNum.getText());
        double amount = Double.parseDouble(dAmount.getText());
        Main.info.deposit(acn,amount);
        JOptionPane.showMessageDialog(null,"Deposit Successful");
       // detail.setText("Deposit Successful");
        acNum.setText(""); dAmount.setText("");
    }

    public void back(ActionEvent event) throws IOException
    {
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        s.hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Fill up Deposit Form");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
