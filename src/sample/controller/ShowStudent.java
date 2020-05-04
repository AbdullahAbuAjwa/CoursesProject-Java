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

public class ShowStudent implements Initializable {
    Navigation navigation = new Navigation();

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
    DBModel db = new DBModel();
    @FXML
    public AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        std_id.setItems(FXCollections.observableArrayList(db.getStdId()));

    }


    public void showInformation() {
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
        }
    }

    public void backToHome() {
        navigation.navTo(root, navigation.move_to_home_page);

    }

    public void addNewStd() {
        navigation.navTo(root, navigation.move_to_add_new_student);
    }
}