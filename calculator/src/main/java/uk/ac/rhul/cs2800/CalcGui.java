package uk.ac.rhul.cs2800;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CalcGui {

  @FXML
  private Button calculate;

  @FXML
  private TextField expression;

  @FXML
  private RadioButton infixButton;

  @FXML
  private ToggleGroup notation;

  @FXML
  private RadioButton polishButton;

  @FXML
  private TextField result;

  @FXML
  void isPressed(ActionEvent event) {
    String expressionText = expression.getText();
    if (infixButton.isSelected() == true) {
      result.setText("Infix: " + expressionText);
    } else {
      result.setText("Reverse Polish: " + expressionText);
    }

  }

}
