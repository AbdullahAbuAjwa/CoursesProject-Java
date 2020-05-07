package sample.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import sample.model.DBModel;
import sample.model.Navigation;
import sample.model.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowLecture implements Initializable {


    // DBModel dbModel = new DBModel();
    DBModel dbModel = new DBModel(LoginController.username, LoginController.password);

    Navigation navigation = new Navigation();
    @FXML
    public AnchorPane root;
    @FXML
    public ComboBox lecture_id;
    @FXML
    public Text course_id;
    @FXML
    public Text lec_ins_id;
    @FXML
    public Text lec_title;
    @FXML
    public Text lec_date;
    @FXML
    public Text count_att;
    @FXML
    public Text percentage_att;
    @FXML
    public Button bt_cancel;
    @FXML
    public Button bt_save;
    @FXML
    public TextField ft_date;
    @FXML
    public TextField ft_title;
    @FXML
    public TableView student_att;
    @FXML
    public TableColumn<Student, Object> std_id;
    @FXML
    public TableColumn<Student, Object> phone_number;
    @FXML
    public TableColumn<Student, Object> first_name;
    @FXML
    public TableColumn<Student, Object> last_name;
    @FXML
    public TableColumn<Student, Object> att;
    @FXML
    public Label txt_std_att;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lecture_id.setItems(FXCollections.observableArrayList(dbModel.getLecturesIDs()));
        std_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        first_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        att.setCellValueFactory(new PropertyValueFactory<>("att"));

    }

    public void showInformation() {
        double count = Integer.parseInt(dbModel.allOfAtt(lecture_id.getValue().toString()));
        double att_true = Integer.parseInt(dbModel.countOfAtt(lecture_id.getValue().toString()));
        double percentage = (att_true / count) * 100;

        if (lecture_id.getValue() != null) {
            student_att.setItems(FXCollections.observableArrayList(
                    dbModel.showStudentWhoAttInfo(lecture_id.getValue().toString())));

            course_id.setText(dbModel.getCoursesToLecture(lecture_id.getValue().toString()));
            lec_ins_id.setText(dbModel.getInstIDsToLecture(lecture_id.getValue().toString()));
            lec_title.setText(dbModel.getTitleLecture(lecture_id.getValue().toString()));
            lec_date.setText(dbModel.getDateLecture(lecture_id.getValue().toString()));
            count_att.setText(dbModel.countOfAtt(lecture_id.getValue().toString()));
            ft_title.setText(dbModel.getTitleLecture(lecture_id.getValue().toString()));
            ft_date.setText(dbModel.getDateLecture(lecture_id.getValue().toString()));

            if (count == 0) {
                percentage_att.setText("0 %");
            } else {
                percentage_att.setText(percentage + " %");

            }
        }
    }

    public void backToHome(ActionEvent actionEvent) {
        navigation.navTo(root, navigation.move_to_home_page);
    }

    public void editLecture(ActionEvent actionEvent) {
        ft_title.setVisible(true);
        ft_date.setVisible(true);
        bt_save.setVisible(true);
        bt_cancel.setVisible(true);

        txt_std_att.setVisible(false);
        student_att.setVisible(false);
        lec_title.setVisible(false);
        lec_date.setVisible(false);
    }

    public void deleteCourse(ActionEvent actionEvent) {
        if (lecture_id.getValue().toString() != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Delete lecture");
            alert.setHeaderText("Delete lecture");
            alert.setContentText("Are you sure ?");
            alert.showAndWait().ifPresent(rs -> {
                dbModel.deleteLecture(lecture_id.getValue().toString());

            });
        }
    }

    public void saveChange(ActionEvent actionEvent) {
        ft_title.setVisible(false);
        ft_date.setVisible(false);
        bt_save.setVisible(false);
        bt_cancel.setVisible(false);

        txt_std_att.setVisible(true);
        student_att.setVisible(true);
        lec_title.setVisible(true);
        lec_date.setVisible(true);
    }

    public void Cancel(ActionEvent actionEvent) {
        ft_title.setVisible(false);
        ft_date.setVisible(false);
        bt_save.setVisible(false);
        bt_cancel.setVisible(false);

        txt_std_att.setVisible(true);
        student_att.setVisible(true);
        lec_title.setVisible(true);
        lec_date.setVisible(true);
    }


    public void searchLecture(ActionEvent actionEvent) {
        navigation.navTo(root, navigation.move_to_search_lecture);
    }
}
