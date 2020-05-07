package sample.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import sample.model.Course;
import sample.model.DBModel;
import sample.model.Navigation;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class ShowCourses implements Initializable {


    Navigation navigation = new Navigation();
    DBModel dbModel = new DBModel();
//    DBModel dbModel = new DBModel(LoginController.username,LoginController.password);

    @FXML
    public AnchorPane root;
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
    @FXML
    public Text ins_id_of_course;

    @FXML
    public ComboBox allCoursesIDs;
    @FXML
    public Button deleteCourse;
    @FXML
    public Button editCourse;
    @FXML
    public TextField ft_name;
    @FXML
    public TextField ft_place;
    @FXML
    public TextField ft_book;
    @FXML
    public Button save_changes;
    @FXML
    public Button cancel_changes;
    @FXML
    public TableView lecture_of_course_table;
    @FXML
    public TableColumn<Course, Object> lec_id;
    @FXML
    public TableColumn<Course, Object> lec_title;
    @FXML
    public TableColumn<Course, Object> lec_date;
    @FXML
    public Button add_lec;
    @FXML
    public Label text_lec_of_course;
    @FXML
    public TextField add_lec_id;
    @FXML
    public TextField add_lec_title;
    @FXML
    public TextField add_lec_date;
    @FXML
    public Label text_add_new_lec;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allCoursesIDs.setItems(FXCollections.observableArrayList(dbModel.getCourseIDs()));
        lec_id.setCellValueFactory(new PropertyValueFactory<>("lec_id"));
        lec_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        lec_date.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    public void addNewCourse(ActionEvent actionEvent) {
        navigation.navTo(root, navigation.move_to_add_new_course);
    }


    public void showInfo() {

        //  System.out.println(dbModel.showLectureOfCourseInfo(allCoursesIDs.getValue().toString()));
        if (allCoursesIDs.getValue() != null) {
            lecture_of_course_table.setItems(FXCollections.observableArrayList(
                    dbModel.showLectureOfCourseInfo(allCoursesIDs.getValue().toString()
                    )));
            course_name.setText(dbModel.getNameCourse(allCoursesIDs.getValue().toString()));
            course_book.setText(dbModel.getBookCourse(allCoursesIDs.getValue().toString()));
            course_place.setText(dbModel.getPlaceCourse(allCoursesIDs.getValue().toString()));
            ins_name_of_course.setText(dbModel.getInstNameOfCourse(allCoursesIDs.getValue().toString()));
            ins_id_of_course.setText(dbModel.getInstIDsOfCourse(allCoursesIDs.getValue().toString()));
            course_count_of_std.setText(dbModel.CountOfStudentTakeCourse(allCoursesIDs.getValue().toString()));
            //
            ft_name.setText(dbModel.getNameCourse(allCoursesIDs.getValue().toString()));
            ft_book.setText(dbModel.getBookCourse(allCoursesIDs.getValue().toString()));
            ft_place.setText(dbModel.getPlaceCourse(allCoursesIDs.getValue().toString()));

        }
    }

    public void backToHome() {
        navigation.navTo(root, navigation.move_to_home_page);
    }

    public void deleteCourse() {
        if (allCoursesIDs.getValue().toString() != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Delete course");
            alert.setHeaderText("Delete course");
            alert.setContentText("Are you sure ?");
            alert.showAndWait().ifPresent(rs -> {
                dbModel.deleteCourse(allCoursesIDs.getValue().toString());
            });
        }
    }


    public void editCourse() {
        course_name.setVisible(false);
        course_book.setVisible(false);
        course_place.setVisible(false);
        lecture_of_course_table.setVisible(false);
        add_lec.setVisible(false);
        text_lec_of_course.setVisible(false);
        add_lec_id.setVisible(false);
        add_lec_title.setVisible(false);
        add_lec_date.setVisible(false);
        text_add_new_lec.setVisible(false);

        //
        ft_name.setVisible(true);
        ft_book.setVisible(true);
        ft_place.setVisible(true);
        save_changes.setVisible(true);
        cancel_changes.setVisible(true);

    }

    public void updateData(ActionEvent actionEvent) {
        dbModel.updateCourse(allCoursesIDs.getValue().toString(), ft_name.getText(),
                ft_book.getText(), ft_place.getText());
        showAlert("Success", "Success", "Data updated successfully");
        course_name.setVisible(true);
        course_book.setVisible(true);
        course_place.setVisible(true);
        lecture_of_course_table.setVisible(true);
        add_lec.setVisible(true);
        text_lec_of_course.setVisible(true);
        add_lec_id.setVisible(true);
        add_lec_title.setVisible(true);
        add_lec_date.setVisible(true);
        text_add_new_lec.setVisible(true);

        //
        ft_name.setVisible(false);
        ft_book.setVisible(false);
        ft_place.setVisible(false);
        save_changes.setVisible(false);
        cancel_changes.setVisible(false);

    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait().ifPresent(rs -> {
        });
    }

    public void cancelUpdateData(ActionEvent actionEvent) {
        course_name.setVisible(true);
        course_book.setVisible(true);
        course_place.setVisible(true);
        lecture_of_course_table.setVisible(true);
        add_lec.setVisible(true);
        text_lec_of_course.setVisible(true);
        add_lec_id.setVisible(true);
        add_lec_title.setVisible(true);
        add_lec_date.setVisible(true);
        text_add_new_lec.setVisible(true);

        //
        ft_name.setVisible(false);
        ft_book.setVisible(false);
        ft_place.setVisible(false);
        save_changes.setVisible(false);
        cancel_changes.setVisible(false);
    }

    public void addNewLecture() {
        if (allCoursesIDs.getValue() != null && add_lec_id.getText() != null
                && add_lec_title.getText() != null && add_lec_date != null
                && ins_id_of_course.getText() != null) {
            if (dbModel.insertLecture(add_lec_id.getText(), allCoursesIDs.getValue().toString(), ins_id_of_course.getText(),
                    add_lec_title.getText(), Date.valueOf(add_lec_date.getText()))) {
                showAlert("Success", "Success", "Lecture added successfully");
            }
        }
    }
}
