package sample.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import sample.model.DBModel;
import sample.model.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowInstructor implements Initializable {
    @FXML
    public AnchorPane root;
    DBModel db = new DBModel();
    Navigation navigation = new Navigation();

    @FXML
    public ComboBox instructor_id;
    @FXML
    public Text ins_name;
    @FXML
    public Text ins_phone;
    @FXML
    public Text ins_teaches;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instructor_id.setItems(FXCollections.observableArrayList(db.getInstructorsIDs()));

    }

    public void showInformation() {
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
}
