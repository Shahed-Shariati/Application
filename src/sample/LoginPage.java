package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;

public class LoginPage {
  private static   Connection connection;
  private static   Statement statement;
   static String  userName;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassWord;

    @FXML
    private JFXButton btnSingUp;

    public LoginPage() throws SQLException {
    }


    public void btnSingUp(javafx.event.ActionEvent actionEvent) throws IOException {
        String user;
        String pass;
        //Check txtfield to not empty

        boolean checkUserPass=false;
      if(txtUserName.getText().trim().isEmpty() && txtPassWord.getText().trim().isEmpty())
      {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("WARNING");
          alert.setContentText("Username & Password is empty:");
          alert.showAndWait();

      }else  if(txtUserName.getText().trim().isEmpty())
      {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("WARNING");
          alert.setContentText("Username is empty");
          alert.showAndWait();
      }else if(txtPassWord.getText().trim().isEmpty())
      {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("WARNING");
          alert.setContentText("Password is empty:");
          alert.showAndWait();
      }
      //Data base connect
      else
       {

           try
           {
               DataBaseConnect();
               ResultSet resultSet = statement.executeQuery("select OpreatorUser,OpreatorPass from Login");
               while (resultSet.next())
               {
                    userName = user = resultSet.getString(1);
                   pass = resultSet.getString(2);
                   if(txtUserName.getText().compareTo(user) == 0 && txtPassWord.getText().compareTo(pass)==0)
                   {
                       checkUserPass = true;
                       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                       alert.setTitle("INFORMATION");
                       alert.setContentText("Well come:");
                       alert.showAndWait();
                       break;

                   }
               }
               resultSet.close();
               statement.close();
               connection.close();

           }catch (SQLException e)
           {

           }


       }
      // check user a pass is correct or no correct
      if(checkUserPass)
      {
          txtPassWord.setText("");
          txtUserName.setText("");
          Stage stage = (Stage) btnSingUp.getScene().getWindow();
          stage.close();
          Stage primaryStage = new Stage();
          AnchorPane root =  FXMLLoader.load(getClass().getResource("MainPage.fxml"));
          Scene scene = new Scene(root,1350, 700);
          primaryStage.setScene(scene);
          primaryStage.show();


      }else
      {
          Alert alert = new Alert(Alert.AlertType.WARNING);
          alert.setTitle("WARNING");
          alert.setContentText("Username and Password incorrect:");
          alert.showAndWait();
      }

       /* Stage stage = (Stage) btnSingUp.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root =  FXMLLoader.load(getClass().getResource("Operator.fxml"));
        Scene scene = new Scene(root,372, 458);
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("he;llo"); */
    }
    public void DataBaseConnect()
    {
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=shahed", "admin1", "123qweR");
            statement = connection.createStatement();
        }catch (SQLException e)
        {

        }
    }
    public void initialize()
    {
        txtUserName.setStyle("-fx-text-inner-color: #FFFFFF");
        txtPassWord.setStyle("-fx-text-inner-color: #FFFFFF");
    }
    public static String getUserName()
    {
        return userName;
    }
}
