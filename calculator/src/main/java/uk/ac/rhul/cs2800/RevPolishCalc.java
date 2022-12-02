package uk.ac.rhul.cs2800;

import java.util.regex.Pattern;

/**
 * @author bensh
 *
 */
public class RevPolishCalc implements CalcInterface {
  NumStack values;

  private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
  
  public RevPolishCalc() {
    values = new NumStack();
  }

  @Override
  public float evaluate(String expression) throws InvalidExpressionException, BadTypeException {
    String[] splitExpression = expression.split(" ");
    for (int i = 0; i < splitExpression.length; i++) {
      if (pattern.matcher(splitExpression[i]).matches()) {
        values.push(Float.parseFloat(splitExpression[i]));
      } else {
        switch (splitExpression[i]) {
          case "+":
            values.push(values.pop() + values.pop());
            break;
          case "-":
            values.push(-values.pop() + values.pop());
            break;
          case "*":
            values.push(values.pop() * values.pop());
            break;
          case "/":
            values.push(1 / values.pop() * values.pop());
            break;
          default:
            //exception
        }
      }
    }
    return values.pop();
  }

}
