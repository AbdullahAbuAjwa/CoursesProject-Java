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
    //DBModel db = new DBModel();
    DBModel db = new DBModel(LoginController.username, LoginController.password);

    //  DBModel db = new DBModel(LoginController.username,LoginController.password);

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
        if (ID.getText().equals("") || name.getText().equals("") || book.getText().equals("")
                || place.getText() == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Error", "Please fill all fields");

        } else {
            if (db.insertCourse(ID.getText(),
                    name.getText(), book.getText(),
                    place.getText())) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Success", "The course added");
                ID.clear();
                name.clear();
                book.clear();
                place.clear();
            }
        }
    }

    public void showAlert(Alert.AlertType type, String message, String header, String content) {
        Alert alert = new Alert(type);
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
