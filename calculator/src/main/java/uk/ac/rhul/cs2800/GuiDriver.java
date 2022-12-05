package uk.ac.rhul.cs2800;

import java.io.IOException;
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
  // private static ContInterface controller;


  public static void initiateGui(String[] args) {
    GuiDriver.main(args);
  }

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader fxml;

    fxml = new FXMLLoader(CalcGui.class.getResource("/calcGui.fxml"));

    Scene scene = null;
    try {
      scene = new Scene(fxml.load(), 300, 310);
    } catch (IOException e) {
      e.printStackTrace();
    }
    // FXMLLoader fxml = new FXMLLoader(CalcGui.class.getResource("/calcGui.fxml"));
    // controller.createView(fxml.getController());
    // Parent root = fxml.load();
    // Scene scene = new Scene(root, 300, 310);
    primaryStage.setResizable(false);
    primaryStage.setTitle("Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }


}
