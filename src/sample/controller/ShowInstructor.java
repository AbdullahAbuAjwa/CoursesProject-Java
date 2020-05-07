package sample.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import sample.model.DBModel;
import sample.model.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowInstructor implements Initializable {

    DBModel db = new DBModel();
    //DBModel db = new DBModel(LoginController.username,LoginController.password);

    Navigation navigation = new Navigation();

    @FXML
    public ComboBox instructor_id;
    @FXML
    public Text ins_name;
    @FXML
    public Text ins_phone;
    @FXML
    public Text ins_teaches;
    @FXML
    public AnchorPane root;
    @FXML
    public ComboBox course_id;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instructor_id.setItems(FXCollections.observableArrayList(db.getInstructorsIDs()));

    }

    public void showInformation() {
        course_id.setItems(FXCollections.observableArrayList(db.getCourseExceptTeaches()));

        if (instructor_id.getValue() != null) {
            ins_name.setText(db.getInstructorName(instructor_id.getValue().toString()));
            ins_phone.setText(String.valueOf(db.getPhoneInstructor(instructor_id.getValue().toString())));
            ins_teaches.setText(String.valueOf(db.getCoursesInstructorTeaches(instructor_id.getValue().toString())));
        }
    }

    public void addNewInstructor() {
        navigation.navTo(root, navigation.move_to_add_new_instructor);

    }

    public void backToHome(ActionEvent actionEvent) {
        navigation.navTo(root, navigation.move_to_home_page);

    }

    public void addInsToNewCourse(ActionEvent actionEvent) {
        if (instructor_id.getValue().toString() != null) {
            if (db.insertInsToCourse(instructor_id.getValue().toString(), course_id.getValue().toString())) {
                showAlert("Success", "Added Successfully", "The student added to the course successfully");
            }
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
}
