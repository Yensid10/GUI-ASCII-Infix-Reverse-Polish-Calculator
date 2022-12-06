package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;
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
public class CalcJavaFx implements ViewInterface {
  CalcModel calculator;

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
  void isPressed(ActionEvent event) throws InvalidExpressionException, BadTypeException {
    calculator = new CalcModel();
    String answer;
    try {
      answer = Float.toString(calculator.evaluate(getExpression(), getFix()));
      result.setStyle("-fx-background-color: #00000025;");
    } catch (Exception e) { 
      // add dividing by zero & overflow errors
      answer = "INVALID EXPRESSION";
      result.setStyle("-fx-background-color: #ff000065;");
    }
    setAnswer(answer);
  }

  @Override
  public String getExpression() {
    return expression.getText();
  }

  @Override
  public void setAnswer(String result) {
    this.result.setText(result);
  }

  @Override
  public boolean getFix() {
    if (infixButton.isSelected() == true) {
      return false;
    }
    return true;
  }
}
