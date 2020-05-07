package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.model.DBModel;
import sample.model.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public static String username;
    public static String password;
    DBModel dbModel = new DBModel();

    @FXML
    public TextField ft_password;
    @FXML
    public TextField ft_userName;
    Navigation navigation = new Navigation();


    @FXML
    public AnchorPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        DBModel.username = ft_userName.getText();
//        DBModel.password = ft_userName.getText();
//
    }

    public void navHomePage() {
        navigation.navTo(rootPane, navigation.move_to_home_page);
    }

}
