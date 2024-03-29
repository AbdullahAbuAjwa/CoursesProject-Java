package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controller.LoginController;
import sample.model.DBModel;

public class Main extends Application {
    //  DBModel dbModel = new DBModel();
    DBModel dbModel = new DBModel(LoginController.username, LoginController.password);

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/HomePage.fxml"));
        primaryStage.setTitle("Database project");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Closed");
        dbModel.exit();
    }
}

