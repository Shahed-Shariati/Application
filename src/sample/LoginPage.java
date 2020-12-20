package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginPage {

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassWord;

    @FXML
    private JFXButton btnSingUp;



    public void btnSingUp(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnSingUp.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root =  FXMLLoader.load(getClass().getResource("Operator.fxml"));
        Scene scene = new Scene(root,372, 458);
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("he;llo");
    }
}
