package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/calcGui.fxml"));
    Scene scene = new Scene(root, 300, 350);
    primaryStage.setResizable(false);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
