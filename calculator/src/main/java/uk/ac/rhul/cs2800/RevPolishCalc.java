package uk.ac.rhul.cs2800;

/**
 * @author bensh
 *
 */
public class RevPolishCalc implements CalcInterface {
  NumStack values;

  public RevPolishCalc() {
    values = new NumStack();
  }

  @Override
  public float evaluate(String expression) throws InvalidExpressionException, BadTypeException {
    String[] splitExpression = expression.split(" ");
    for (int i = 0; i < splitExpression.length; i++) {
      try {
        values.push(Float.parseFloat(splitExpression[i]));
      } catch (Exception e) {
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
            throw new InvalidExpressionException("INVALID EXPRESSION");
        }
      }
    }
    return values.pop();
  }
}
