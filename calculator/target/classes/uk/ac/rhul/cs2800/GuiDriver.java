package uk.ac.rhul.cs2800;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The driver class required to run a JavaFx application.
 *
 * @author bensh
 */
public class GuiDriver extends Application {

  /**
   * A required function that will redirect to a main function that initiates the JavaFx launch.
   *
   * @param args command line arguments passed into the initial main method
   */
  public static void initiateGui(String[] args) {
    main(args);
  }

  /**
   * The main function that initiates the JavaFx launch.
   *
   * @param args command line arguments passed into the initial main method
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/calcGui.fxml"));
    Scene scene = new Scene(root, 300, 310);
    primaryStage.setResizable(false); // Chosen as calculator does not aesthetically resize
    primaryStage.setTitle("Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
