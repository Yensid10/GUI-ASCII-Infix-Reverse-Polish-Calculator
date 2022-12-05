package uk.ac.rhul.cs2800;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
  // String expression;
  // String answer;
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
    float answer = calculator.evaluate(getExpression(), getFix());
    setAnswer(answer);
  }

  @Override
  public String getExpression() {
    return expression.getText();
  }

  @Override
  public void setAnswer(float result) {
    this.result.setText(Float.toString(result));

  }

  @Override
  public boolean getFix() {
    if (infixButton.isSelected() == true) {
      return false;
    }
    return true;
  }

  // @Override
  // public void addObserver(Observer observer) {
  // calculate.setOnAction(new EventHandler<ActionEvent>() {
  //
  // public void handle(ActionEvent event) {
  // observer.notification();
  // }
  // });
  // }


}
