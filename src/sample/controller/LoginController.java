package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.postgresql.ds.PGSimpleDataSource;
import sample.model.DBModel;
import sample.model.Navigation;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public static String username;
    public static String password;
    //   DBModel dbModel = new DBModel();


    @FXML
    public TextField ft_password;
    @FXML
    public TextField ft_userName;
    Navigation navigation = new Navigation();


    @FXML
    public AnchorPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void navHomePage() {
        username = ft_userName.getText();
        password = ft_password.getText();
        DBModel db = new DBModel(username, password);
        navigation.navTo(rootPane, navigation.move_to_home_page);
    }
}
