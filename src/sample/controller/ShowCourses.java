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

public class ShowCourses implements Initializable {

    @FXML
    public ComboBox allCoursesIDs;
    Navigation navigation = new Navigation();
    DBModel dbModel = new DBModel();
    @FXML
    public AnchorPane root;
    @FXML
    public TextField course_id;
    @FXML
    public Text course_name;
    @FXML
    public Text course_place;
    @FXML
    public Text course_book;
    @FXML
    public Text course_count_of_std;
    @FXML
    public Text ins_name_of_course;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allCoursesIDs.setItems(FXCollections.observableArrayList(dbModel.getCourseIDs()));

    }

    public void addNewCourse(ActionEvent actionEvent) {
        navigation.navTo(root, navigation.move_to_add_new_course);
    }


    public void showInfo() {
        if (allCoursesIDs.getValue() != null) {
            course_name.setText(dbModel.getNameCourse(allCoursesIDs.getValue().toString()));
            course_book.setText(dbModel.getBookCourse(allCoursesIDs.getValue().toString()));
            course_place.setText(dbModel.getPlaceCourse(allCoursesIDs.getValue().toString()));
            ins_name_of_course.setText(dbModel.getInstNameOfCourse(allCoursesIDs.getValue().toString()));
            course_count_of_std.setText(dbModel.CountOfStudentTakeCourse(allCoursesIDs.getValue().toString()));
        }
    }

    public void backToHome() {
        navigation.navTo(root, navigation.move_to_home_page);
    }

}
