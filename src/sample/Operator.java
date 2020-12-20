package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Operator {
    OperatorSerGet operatorSerGet = new OperatorSerGet();

    @FXML
    private JFXTextField txtOperatorName;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassWord;

    @FXML
    private JFXButton btnVerify;

    @FXML
    private JFXButton btnBack;



    public void btnVerify(javafx.event.ActionEvent actionEvent)
    {

        operatorSerGet.setOperatorName(txtOperatorName.getText());
        operatorSerGet.setOperatorUserName(txtUserName.getText());
        operatorSerGet.setOperatorPass(txtPassWord.getText());
        System.out.println(operatorSerGet.getOperatorUserName());
    }

    public void btnBack(javafx.event.ActionEvent actionEvent) throws SQLException, IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root =  FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene scene = new Scene(root,364, 444);
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("he;llo");
    }

    public void pressBtnDone(ActionEvent actionEvent) {
        try {

            // Operator operator = new Operator();
            DataBase dataBase;
            dataBase = new DataBase();
            dataBase.setQuery("insert into Login (OpraterName,OpreatorUser,OpreatorPass) values (?,?,?)");
            dataBase.InsertData(operatorSerGet);

        }catch (Exception e){
            System.out.println("Error");
        }
    }
    public void initialize(){
       txtOperatorName.setStyle("-fx-text-inner-color: #FFFFFF");
    }
}
