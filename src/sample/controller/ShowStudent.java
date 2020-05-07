package sample.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import sample.model.DBModel;
import sample.model.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ShowStudent implements Initializable {


    Navigation navigation = new Navigation();
    DBModel db = new DBModel();
    //DBModel db = new DBModel(LoginController.username, LoginController.password);


    @FXML
    public Text std_first_name;
    @FXML
    public Text std_father_name;
    @FXML
    public Text std_gfather_name;
    @FXML
    public Text std_last_name;
    @FXML
    public Text std_city;
    @FXML
    public Text std_district;
    @FXML
    public Text std_street;
    @FXML
    public Text std_gender;
    @FXML
    public Text std_takes;
    @FXML
    public Text std_phone;
    @FXML
    public ComboBox std_id;
    @FXML
    public ComboBox coursesIds;
    @FXML
    public AnchorPane root;
    @FXML
    public TextField another_phone;
    @FXML
    public Button add_label_phone;
    @FXML
    public Button addStdToCourse;
    //
    @FXML
    public TextField tf_first_name;
    @FXML
    public TextField tf_father_name;
    @FXML
    public TextField tf_grand_father_name;
    @FXML
    public TextField tf_last_name;
    @FXML
    public TextField tf_district;
    @FXML
    public TextField tf_street;
    @FXML
    public ComboBox cb_city;
    @FXML
    public ComboBox cb_gender;
    @FXML
    public Button bt_save_changes;
    @FXML
    public Button bt_cancel;
    @FXML
    public Label text_add;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        std_id.setItems(FXCollections.observableArrayList(db.getStdId()));
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Gaza");
        cities.add("Rafah");
        cities.add("Khanyounis");
        cities.add("Jabalya");
        cities.add("BeitLahya");
        cities.add("BeitHanoon");
        cities.add("AlWosta");
        cb_city.setItems(FXCollections.observableArrayList(cities));

        ArrayList<String> selectGender = new ArrayList<>();
        selectGender.add("Male");
        selectGender.add("Female");
        cb_gender.setItems(FXCollections.observableArrayList(selectGender));
    }


    public void showInformation() {
        coursesIds.setItems(FXCollections.observableArrayList(db.getCourseExcept(std_id.getValue().toString())));

        if (std_id.getValue() != null) {
            std_first_name.setText(db.getFirstStdName(std_id.getValue().toString()));
            std_father_name.setText(db.getFatherStdName(std_id.getValue().toString()));
            std_gfather_name.setText(db.getGrandFatherStdName(std_id.getValue().toString()));
            std_last_name.setText(db.getLastStdName(std_id.getValue().toString()));
            std_city.setText(db.getCityStd(std_id.getValue().toString()));
            std_district.setText(db.getDistrictStd(std_id.getValue().toString()));
            std_street.setText(db.getStreetStd(std_id.getValue().toString()));
            std_gender.setText(db.getGenderStd(std_id.getValue().toString()));
            std_phone.setText(String.valueOf(db.getPhoneStd(std_id.getValue().toString())));
            std_takes.setText(String.valueOf(db.getCoursesTakeStd(std_id.getValue().toString())));
            //
            tf_first_name.setText(db.getFirstStdName(std_id.getValue().toString()));
            tf_father_name.setText(db.getFatherStdName(std_id.getValue().toString()));
            tf_grand_father_name.setText(db.getGrandFatherStdName(std_id.getValue().toString()));
            tf_last_name.setText(db.getLastStdName(std_id.getValue().toString()));
            cb_city.setValue(db.getCityStd(std_id.getValue().toString()));
            tf_district.setText(db.getDistrictStd(std_id.getValue().toString()));
            tf_street.setText(db.getStreetStd(std_id.getValue().toString()));
            cb_gender.setValue(db.getGenderStd(std_id.getValue().toString()));
        }
    }

    public void backToHome() {
        navigation.navTo(root, navigation.move_to_home_page);

    }

    public void addNewStd() {
        navigation.navTo(root, navigation.move_to_add_new_student);
    }

    public void addStdToNewCourse() {
        if (coursesIds.getValue().toString() != null) {
            db.insertStdToCourse(std_id.getValue().toString(), coursesIds.getValue().toString());
            showAlert("Success", "Added Successfully", "The student added to the course successfully");

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

    public void addLabelPhone(ActionEvent actionEvent) {
        another_phone.setVisible(true);
    }

    public void addNewPhone() {
        if (another_phone.getText() != null) {
            db.insertPhoneStudent(std_id.getValue().toString(), Integer.parseInt(another_phone.getText()));
            showAlert("Success", "Added Successfully", "The new phone added successfully");
            another_phone.setVisible(false);
        }
    }

    public void deleteStudent() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Delete student");
        alert.setHeaderText("Delete student");
        alert.setContentText("Are you sure ?");

        alert.showAndWait().ifPresent(rs -> {
            if (std_id.getValue().toString() != null) {
                db.deleteStudent(std_id.getValue().toString());
                showAlert("Deleted Successfully", "Deleted Successfully", "The student deleted");
            }
        });
    }

    public void editData(ActionEvent actionEvent) {
        std_first_name.setVisible(false);
        std_father_name.setVisible(false);
        std_gfather_name.setVisible(false);
        std_last_name.setVisible(false);
        std_city.setVisible(false);
        std_district.setVisible(false);
        std_street.setVisible(false);
        std_gender.setVisible(false);
        another_phone.setVisible(false);
        add_label_phone.setVisible(false);
        addStdToCourse.setVisible(false);
        coursesIds.setVisible(false);
        text_add.setVisible(false);


        //
        tf_first_name.setVisible(true);
        tf_father_name.setVisible(true);
        tf_grand_father_name.setVisible(true);
        tf_last_name.setVisible(true);
        tf_district.setVisible(true);
        tf_street.setVisible(true);
        cb_city.setVisible(true);
        cb_gender.setVisible(true);
        bt_save_changes.setVisible(true);
        bt_cancel.setVisible(true);
    }

    public void saveChanges(ActionEvent actionEvent) {

        if (db.updateStudent(std_id.getValue().toString(), tf_first_name.getText(),
                tf_father_name.getText(),
                tf_grand_father_name.getText(),
                tf_last_name.getText(),
                cb_city.getValue().toString(),
                tf_district.getText(),
                tf_street.getText(),
                cb_gender.getValue().toString())) {

            showAlert("Success", "Success", "Data updated successfully");

            std_first_name.setVisible(true);
            std_father_name.setVisible(true);
            std_gfather_name.setVisible(true);
            std_last_name.setVisible(true);
            std_city.setVisible(true);
            std_district.setVisible(true);
            std_street.setVisible(true);
            std_gender.setVisible(true);
            addStdToCourse.setVisible(true);
            add_label_phone.setVisible(true);
            coursesIds.setVisible(true);
            text_add.setVisible(true);

            //
            tf_first_name.setVisible(false);
            tf_father_name.setVisible(false);
            tf_grand_father_name.setVisible(false);
            tf_last_name.setVisible(false);
            tf_district.setVisible(false);
            tf_street.setVisible(false);
            cb_city.setVisible(false);
            cb_gender.setVisible(false);
            bt_save_changes.setVisible(false);
            bt_cancel.setVisible(false);
        }
    }

    public void cancel(ActionEvent actionEvent) {

        std_first_name.setVisible(true);
        std_father_name.setVisible(true);
        std_gfather_name.setVisible(true);
        std_last_name.setVisible(true);
        std_city.setVisible(true);
        std_district.setVisible(true);
        std_street.setVisible(true);
        std_gender.setVisible(true);
        addStdToCourse.setVisible(true);
        add_label_phone.setVisible(true);
        coursesIds.setVisible(true);
        text_add.setVisible(true);

        //
        tf_first_name.setVisible(false);
        tf_father_name.setVisible(false);
        tf_grand_father_name.setVisible(false);
        tf_last_name.setVisible(false);
        tf_district.setVisible(false);
        tf_street.setVisible(false);
        cb_city.setVisible(false);
        cb_gender.setVisible(false);
        bt_save_changes.setVisible(false);
        bt_cancel.setVisible(false);
    }
}