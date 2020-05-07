package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import sample.model.DBModel;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentCommitted implements Initializable {
    DBModel dbModel = new DBModel(LoginController.username, LoginController.password);
    @FXML
    public AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(dbModel.CountLecturesForCourse());
    }
}