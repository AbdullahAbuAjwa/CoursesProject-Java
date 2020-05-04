package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import sample.model.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {
    Navigation navigation = new Navigation();

    @FXML
    public AnchorPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void navHomePage() {
        navigation.navTo(rootPane, navigation.move_to_home_page);
    }

}
