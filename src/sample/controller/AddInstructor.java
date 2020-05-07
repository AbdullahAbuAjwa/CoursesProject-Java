package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.model.DBModel;
import sample.model.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class AddInstructor implements Initializable {
    @FXML
    public AnchorPane root;
    DBModel db = new DBModel();
    Navigation navigation = new Navigation();

    @FXML
    public TextField ID;
    @FXML
    public TextField name;
    //DBModel dbModel = new DBModel(LoginController.username,LoginController.password);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void Save(ActionEvent actionEvent) {
        if (ID.getText() == null || name.getText() == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Error", "Please Enter all fields");
        } else {
            if (db.insertInstructor(ID.getText(), name.getText())) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Success", "The student Added Successfully");
                ID.clear();
                name.clear();
            }
        }
    }

    public void Back(ActionEvent actionEvent) {
        navigation.navTo(root, navigation.move_to_show_inst);
    }

    public void showAlert(Alert.AlertType type, String message, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(message);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait().ifPresent(rs -> {
        });
    }
}
