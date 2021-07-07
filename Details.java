package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Details {
    @FXML
    private TextArea information;
    public static int i=0;
    public void call(int i){
            BankAccount inf = Main.info.display(i);
            information.setText(inf+" ");
    }
    public void start(ActionEvent event) throws IOException{
        call(0);
    }
    public void next(ActionEvent event) throws IOException{
        if(i<Main.info.accountSize()-1) {
            i += 1;
            call(i);
        } else{ information.setText("NO more Account"); i=Main.info.accountSize(); }
    }
    public void previous(ActionEvent event) throws IOException{
        if(i>0) {
            i -= 1;
            call(i);
        }
        else { information.setText("No Account"); i=-1; }
    }

    public void back(ActionEvent event) throws IOException
    {
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        s.hide();
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Account Holders Details");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
