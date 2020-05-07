package sample.controller;

import javafx.collections.FXCollections;
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

public class SearchLecture implements Initializable {
    @FXML
    public Text course_id;
    @FXML
    public Text lec_ins_id;
    @FXML
    public Text lec_id;
    @FXML
    public Text lec_date;
    @FXML
    public Text count_att;
    @FXML
    public TextField tf_title;
    //DBModel dbModel = new DBModel();
    DBModel dbModel = new DBModel(LoginController.username, LoginController.password);

    Navigation navigation = new Navigation();
    @FXML
    public AnchorPane root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void back(ActionEvent actionEvent) {
        navigation.navTo(root, navigation.move_to_show_lecture);
    }

    public void showInformation(ActionEvent actionEvent) {

        if (tf_title.getText() != null) {

            course_id.setText(dbModel.getCoursesToLecture_Title(tf_title.getText()));
            lec_ins_id.setText(dbModel.getInstIDsToLecture_title(tf_title.getText()));
            lec_id.setText(dbModel.getLecIDTitle(tf_title.getText()));
            lec_date.setText(dbModel.getDateLectureTitle(tf_title.getText()));
            count_att.setText(dbModel.countOfAtt_title(tf_title.getText()));
        }
    }
}
