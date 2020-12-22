package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;

public class MainPage {

    @FXML
    private MenuItem AddProductMenu;

    @FXML
    private Label lblWellcome;


    @FXML
    private MenuItem AddCustomerMenu;

    @FXML
    void PressAddProductMenu(ActionEvent event) {

    }

    @FXML
    void pressAddCustomerMenu(ActionEvent event) {

    }

    @FXML
    void pressCloseMenu(ActionEvent event) {

    }

    public void PressAddProductMenu(javafx.event.ActionEvent actionEvent) {
    }

    public void pressAddCustomerMenu(javafx.event.ActionEvent actionEvent) {
    }

    public void pressCloseMenu(javafx.event.ActionEvent actionEvent)
    {
        Platform.exit();
    }
    public void initialize()
    {
        lblWellcome.setText(LoginPage.getUserName());
    }
}
