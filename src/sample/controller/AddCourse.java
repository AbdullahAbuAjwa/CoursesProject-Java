package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.model.DBModel;
import sample.model.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCourse implements Initializable {
    @FXML
    public AnchorPane root;
    Navigation navigation = new Navigation();
    DBModel db = new DBModel();

    @FXML
    public TextField ID;
    @FXML
    public TextField name;
    @FXML
    public TextField book;
    @FXML
    public TextField place;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void addInfo() {
        if (ID.getText() != null && name.getText() != null && book.getText() != null
                && place.getText() != null) {
            if (db.insertCourse(ID.getText(),
                    name.getText(), book.getText(),
                    place.getText())) {
                showAlert("Success", "Success", "The course added");
                ID.clear();
                name.clear();
                book.clear();
                place.clear();
            }
        } else {
            showAlertError("Error", "Error", "Please fill all fields");
        }
    }

    public void showAlert(String message, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(message);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait().ifPresent(rs -> {
        });
    }

    public void showAlertError(String message, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(message);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait().ifPresent(rs -> {
        });
    }

    public void Cancel() {
        navigation.navTo(root, navigation.move_to_show_course);
    }
}
