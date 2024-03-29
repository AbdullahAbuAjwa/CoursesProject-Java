package sample.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class Navigation {
    public final String start = "/sample/view/login.fxml";
    public final String move_to_show_std = "/sample/view/show_student.fxml";
    public final String move_to_show_inst = "/sample/view/show_instructor.fxml";
    public final String move_to_show_course = "/sample/view/show_courses.fxml";
    public final String move_to_show_lecture = "/sample/view/show_lecture.fxml";
    public final String move_to_home_page = "/sample/view/HomePage.fxml";
    public final String move_to_add_new_student = "/sample/view/add_student.fxml";
    public final String move_to_add_new_instructor = "/sample/view/add_instructor.fxml";
    public final String move_to_add_new_course = "/sample/view/add_course.fxml";
    public final String move_to_add_new_att = "/sample/view/add_att.fxml";
    public final String move_to_search_lecture= "/sample/view/search_lecture.fxml";
    public final String move_to_student_committed= "/sample/view/student_committed.fxml";

    public void navTo(Parent rootPane, String path) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            rootPane.getScene().setRoot(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
