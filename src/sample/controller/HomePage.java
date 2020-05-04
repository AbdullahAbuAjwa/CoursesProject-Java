package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import sample.model.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class HomePage implements Initializable {
    Navigation navigation = new Navigation();
    @FXML
    public AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void showStudentInfo() {
        navigation.navTo(root, navigation.move_to_show_std);
    }

    public void showCoursesInfo() {
        navigation.navTo(root, navigation.move_to_show_course);
    }

    public void showInstructorInfo() {
        navigation.navTo(root, navigation.move_to_show_inst);
    }
}
