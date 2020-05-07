package sample.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sample.model.AttendeeList;
import sample.model.DBModel;
import sample.model.Navigation;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddAtt implements Initializable {


    DBModel dbModel = new DBModel();
    //DBModel dbModel = new DBModel(LoginController.username,LoginController.password);
    Navigation navigation = new Navigation();
    @FXML
    public AnchorPane root;
    @FXML
    public Button Back;
    @FXML
    public Button save;
    @FXML
    public ComboBox course_id;
    @FXML
    public ComboBox lec_id;
    @FXML
    public ComboBox phone_std;
    @FXML
    public ComboBox att;
    @FXML
    public TableView att_list_table;
    @FXML
    public TableColumn<AttendeeList, Object> lec_id_table;
    @FXML
    public TableColumn<AttendeeList, Object> course_id_table;
    @FXML
    public TableColumn<AttendeeList, Object> inst_id_table;
    @FXML
    public TableColumn<AttendeeList, Object> title_table;
    @FXML
    public TableColumn<AttendeeList, Object> date_table;
    @FXML
    public TableColumn<AttendeeList, Object> attendee_table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        phone_std.setItems(FXCollections.observableArrayList(dbModel.getPhones()));

        ArrayList<String> atts = new ArrayList<>();
        atts.add("true");
        atts.add("false");
        att.setItems(FXCollections.observableArrayList(atts));

        lec_id_table.setCellValueFactory(new PropertyValueFactory<>("lec_id"));
        course_id_table.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        inst_id_table.setCellValueFactory(new PropertyValueFactory<>("instructor_id"));
        title_table.setCellValueFactory(new PropertyValueFactory<>("title"));
        date_table.setCellValueFactory(new PropertyValueFactory<>("date_lec"));
        attendee_table.setCellValueFactory(new PropertyValueFactory<>("attendee"));

    }

    public void Back(ActionEvent actionEvent) {
        navigation.navTo(root, navigation.move_to_home_page);

    }

    public void show_phones(ActionEvent actionEvent) {
        att_list_table.setVisible(false);
        if (phone_std.getValue() != null) {
            course_id.setItems(FXCollections.observableArrayList(
                    dbModel.getCoursesIDsToAtt(Integer.parseInt(phone_std.getValue().toString()))));
        }
    }

    public void show_courses(ActionEvent actionEvent) {
        if (course_id.getValue() != null) {
            lec_id.setItems(FXCollections.observableArrayList(
                    dbModel.getLecturesIDsToAtt(course_id.getValue().toString())));
        }
    }

    public void ShowAttendanceList(ActionEvent actionEvent) {
        att_list_table.setVisible(true);
        att_list_table.setItems(FXCollections.observableArrayList(
                dbModel.getAttendeesList(Integer.parseInt(phone_std.getValue().toString()))));
    }

    public void addAtt(ActionEvent actionEvent) {
        if (phone_std.getValue() == null
                || course_id.getValue() == null
                || lec_id.getValue() == null
                || att.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Error", "Please Enter all fields");
        } else {
            if (dbModel.insertAttendees(Integer.parseInt(phone_std.getValue().toString()),
                    course_id.getValue().toString(),
                    lec_id.getValue().toString(),
                    Boolean.valueOf(att.getValue().toString()))) {

                showAlert(Alert.AlertType.INFORMATION, "Success", "Success", "The student Added Successfully");
                course_id.setValue("");
                lec_id.setValue("");
                att.setValue("");
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
