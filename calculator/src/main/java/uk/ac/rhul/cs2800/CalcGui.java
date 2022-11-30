package uk.ac.rhul.cs2800;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * @author bensh
 *
 */
public class CalcGui implements ViewInterface {
  String expression;
  String answer;  

  @FXML
  private Button calculate;

  @FXML
  private TextField expressionField;

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
    expression = expressionField.getText();
    if (infixButton.isSelected() == true) {
      result.setText("Infix: " + expression);
    } else {
      result.setText("Reverse Polish: " + expression);
    }

  }

  @Override
  public String expression() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void answer() {
    // TODO Auto-generated method stub
    
  }

}
