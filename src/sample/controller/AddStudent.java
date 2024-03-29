package sample.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.model.DBModel;
import sample.model.Navigation;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddStudent implements Initializable {
    //  DBModel dbModel = new DBModel();
    DBModel dbModel = new DBModel(LoginController.username, LoginController.password);

    Navigation navigation = new Navigation();
    @FXML
    public AnchorPane root;
    @FXML
    public TextField ID;
    @FXML
    public TextField first_name;
    @FXML
    public TextField father_name;
    @FXML
    public TextField grand_father_name;
    @FXML
    public TextField last_name;
    @FXML
    public ComboBox city;
    @FXML
    public TextField district;
    @FXML
    public TextField street;
    @FXML
    public ComboBox gender;
    @FXML
    public TextField phone;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Gaza");
        cities.add("Rafah");
        cities.add("Khanyounis");
        cities.add("Jabalya");
        cities.add("BeitLahya");
        cities.add("BeitHanoon");
        cities.add("AlWosta");
        city.setItems(FXCollections.observableArrayList(cities));

        ArrayList<String> selectGender = new ArrayList<>();
        selectGender.add("Male");
        selectGender.add("Female");
        gender.setItems(FXCollections.observableArrayList(selectGender));
    }

    public void Cancel() {
        navigation.navTo(root, navigation.move_to_show_std);
    }

    public void addStd() {
        if (ID.getText() == null || first_name.getText().equals("")
                || father_name.getText().equals("")
                || grand_father_name.getText().equals("")
                || last_name.getText().equals("")
                || city.getValue().equals("")
                || district.getText().equals("")
                || street.getText().equals("")
                || gender.getValue().equals("")
                || phone.getText().equals("")) {
            showAlert(Alert.AlertType.ERROR, "Error", "Error", "Please Enter all fields");
        } else {
            if (dbModel.insertStudent(ID.getText(),
                    first_name.getText(), father_name.getText(), grand_father_name.getText(),
                    last_name.getText(),
                    city.getValue().toString(),
                    district.getText(),
                    street.getText(),
                    gender.getValue().toString()) &&
                    dbModel.insertPhoneStudent(ID.getText(), Integer.parseInt(phone.getText()))) {

                showAlert(Alert.AlertType.INFORMATION, "Success", "Success", "The student Added Successfully");
                ID.clear();
                first_name.clear();
                father_name.clear();
                grand_father_name.clear();
                last_name.clear();
                city.setValue("");
                district.clear();
                street.clear();
                phone.clear();
                gender.setValue("");
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

}