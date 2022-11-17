package uk.ac.rhul.cs2800;

import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author bensh
 *
 */
public class GuiDriver extends Application {
  
//  public GuiDriver() {
//    
//  }

  public static void initiateGui(String[] args) {
    GuiDriver.main(args);
  }

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/calcGui.fxml"));
    Scene scene = new Scene(root, 300, 310);
    primaryStage.setResizable(false);
    primaryStage.setTitle("Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
