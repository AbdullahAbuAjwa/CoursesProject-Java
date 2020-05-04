package sample.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
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
    DBModel dbModel = new DBModel();
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
    public CheckBox gender;
    @FXML
    public TextField phone;
    String genderSelected;

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
        if (gender.isSelected()) {
            gender.setText("Male");
        } else {
            gender.setText("Female");
        }
    }

    public void Cancel() {
        navigation.navTo(root, navigation.move_to_show_std);
    }

    public void addStd() {
        if (ID.getText() != null && first_name.getText() != null
                && father_name.getText() != null
                && grand_father_name.getText() != null
                && last_name.getText() != null
                && city.getValue().toString() != null
                && district.getText() != null
                && street.getText() != null
                && gender.getText() != null
            //  && street.getText() != null

        ) {

            dbModel.insertStudent(ID.getText(),
                    first_name.getText(), father_name.getText(), grand_father_name.getText(),
                    last_name.getText(),
                    city.getValue().toString(),
                    district.getText(),
                    street.getText(),
                    gender.getText());

            dbModel.insertPhoneStudent(ID.getText(), Integer.parseInt(phone.getText()));
            System.out.println("Added Success");
        } else {
            System.err.println("Null Fields");
        }
        navigation.navTo(root, navigation.move_to_show_std);
    }
}