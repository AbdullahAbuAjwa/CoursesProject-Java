package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    public TextField instructor_id;
    @FXML
    public Text ins_name;
    @FXML
    public Text ins_phone;
    @FXML
    public Text ins_teaches;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void showInformation() {
        if (!instructor_id.getText().equals("")) {
            ins_name.setText(db.getInstructorName(instructor_id.getText()));
            ins_phone.setText(db.getPhoneInstructor(instructor_id.getText()));
            ins_teaches.setText(db.getCoursesInstructorTeaches(instructor_id.getText()));
        }
    }

    public void addNewInstructor() {
        navigation.navTo(root, navigation.move_to_add_new_instructor);

    }

    public void backToHome(ActionEvent actionEvent) {
        navigation.navTo(root, navigation.move_to_home_page);

    }
}
