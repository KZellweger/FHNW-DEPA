package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.ui.MainView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        Parent root = new MainView();
        primaryStage.setTitle("Color Picker");
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
