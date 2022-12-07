package uk.ac.rhul.cs2800;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * A Graphical view for the calculator made using JavaFx.
 *
 * @author bensh
 */
public class CalcJavaFx implements ViewInterface {
  // Since the calculate button will be pressed multiple times,
  // we define the CalcModel here to avoid duplicate creations, same applies for answer
  CalcModel calculator;
  String answer;


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

  /**
   * When the calculate button is pressed, use CalcModel to retrieve an output.
   *
   * @param event a component defined ActionEvent triggered by clicking calculate
   */
  @FXML
  void isPressed(ActionEvent event) {
    // Initiates an instance of the CalcModel used to evaluate given expressions
    calculator = new CalcModel();
    try { // Checks using error-validation that the result we get from our CalcModel is a float
      answer = Float.toString(calculator.evaluate(getExpression(), getFix()));
      if (answer != "Infinity") {
        result.setStyle("-fx-background-color: #00000025;"); // Default background colours
      } else { // Only happens for Overflow errors & Dividing by zero errors
        answer = "MATHS ERROR";
        result.setStyle("-fx-background-color: #ff000070;"); // Red background for errors
      }
    } catch (Exception e) { // Calculators throw different errors for bad inputs, accounts for this
      answer = "INVALID EXPRESSION";
      result.setStyle("-fx-background-color: #ff000070;");
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
    return polishButton.isSelected();
  }
}
