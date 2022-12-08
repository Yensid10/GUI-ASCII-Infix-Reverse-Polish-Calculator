package uk.ac.rhul.cs2800;

/**
 * A calculator algorithm that receives Reverse Polish notation and returns a singular float answer.
 *
 * @author bensh
 */
public class RevPolishCalc implements ModelInterface {
  private NumStack result;

  /**
   * A constructor that initialises instances of the stack type needed to solve Reverse Polish
   * notation expressions into a singular float answer.
   */
  public RevPolishCalc() {
    result = new NumStack();
  }

  @Override
  public float evaluate(String expression) throws InvalidExpressionException, BadTypeException {
    // Splits the passed expression into an array, with each index corresponding to characters
    // between spaces
    String[] splitExpression = expression.split(" ");

    // I validate it is Postfix by checking that the total number of numbers passed in is one more
    // then the total number of operators (num = n, op = n-1), checked at the end of evaluate
    int validationCount = 0;
    for (int i = 0; i < splitExpression.length; i++) {
      try { // Checks if index is a float, if so push it onto the result stack
        result.push(Float.parseFloat(splitExpression[i]));
        validationCount++; // Increment validation count by 1
      } catch (Exception e) {
        switch (splitExpression[i]) {
          case "+":
            // else if its a "+", pop the top 2 floats on the result stack and add them together
            // before pushing the result back on the stack
            result.push(result.pop() + result.pop());
            break;
          case "-":
            // else if its a "-", pop the top 2 floats on the result stack (since this would flip
            // the initial order they were found in the original notation, to make the second number
            // output from the stack minus the first, you must use a - b = -b + a), minus one
            // from the other and push the result back onto the result stack
            result.push(-result.pop() + result.pop());
            break;
          case "*":
            // else if its a "+", pop the top 2 floats on the result stack and times them together
            // before pushing the result back on the stack
            result.push(result.pop() * result.pop());
            break;
          case "/":
            // else if its a "-", pop the top 2 floats on the result stack (since this would flip
            // the initial order they were found in the original notation, to make the second number
            // output from the stack divided by the first, you must use a/b = 1/b * a), divide one
            // by the other and push the result back onto the result stack
            result.push(1 / result.pop() * result.pop());
            break;
          default: // If the index is anything else, then throw an error
            throw new InvalidExpressionException("INVALID EXPRESSION");
        }
        validationCount += -1;
      }
    }
    if (validationCount != 1) { // n - (n - 1) = 1 therefore a valid expression must equal 1
      throw new InvalidExpressionException("INVALID EXPRESSION"); // else an error is thrown
    }
    return result.pop();
  }
}
