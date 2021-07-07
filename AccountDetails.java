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
import javafx.scene.control.Label;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AccountDetails {
    @FXML
    public TextField acNum;
    @FXML
    public TextField password;
    @FXML
    public TextArea information;
    public void enter(ActionEvent event) throws InvalidPasswordException{
        try{
            String acn = acNum.getText();
            String pass = password.getText();
            BankAccount inf = Main.info.display(acn,pass);
            information.setText((inf+" "));
        }catch (InvalidPasswordException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    public void ext(ActionEvent event) throws IOException
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
