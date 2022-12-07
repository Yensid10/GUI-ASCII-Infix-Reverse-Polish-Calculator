package uk.ac.rhul.cs2800;

/**
 * A calculator algorithm that receives Infix notation, converts it into Postfix notation using the
 * Shunting Yard algorithm & feeds it into the Reverse Polish calculator which returns an answer.
 *
 * @author bensh
 */
public class InfixCalc implements ModelInterface {
  OpStack op;
  StrStack str;
  boolean loop;

  /**
   * A constructor that initialises instances of each stack type needed for Shunting Yard algorithm.
   */
  public InfixCalc() {
    op = new OpStack();
    str = new StrStack();
  }

  @Override
  public float evaluate(String expression) throws InvalidExpressionException, BadTypeException {
    // Splits the passed expression into an array, with each index corresponding to characters
    // between spaces
    String[] splitExpression = expression.split(" ");
    // Initial verification to see if the expression given is in Infix notation by checking if the
    // final character/s is either a number or a right bracket, if not it returns an error
    try { // I will always use try catch with parsing floats for verification
      Float.parseFloat(splitExpression[splitExpression.length - 1]);
    } catch (Exception e) {
      if (!splitExpression[splitExpression.length - 1].equals(")")) {
        throw new InvalidExpressionException("INVALID EXPRESSION");
      }
    }
    for (int i = 0; i < splitExpression.length; i++) {
      try { // Check if index is a float, if so push to string stack
        str.push(Float.toString(Float.parseFloat(splitExpression[i])));
      } catch (Exception e) {
        switch (splitExpression[i]) { // Could also be an if statement
          case "(": // else if it's a left bracket, push to operator stack
            op.push(Symbol.LEFT_BRACKET);
            break;
          case ")":
            // else if it's a right bracket, pop from operator stack and push the popped operators
            // onto the string stack until a left bracket is on top of the operator stack, then pop
            // and discard the left bracket
            while (op.opStack.top().getSymbol() != Symbol.LEFT_BRACKET) {
              str.push(op.pop().toString());
            }
            op.pop();
            break;
          default: // else if it's a regular operator...
            if (splitExpression[i].equals("+") || splitExpression[i].equals("-")
                || splitExpression[i].equals("/") || splitExpression[i].equals("*")) {
              loop = true;
              while (loop) {
                // and the operator stack is either empty or has a left bracket on top of it
                // or the regular operator at this index is either a times (*) or a divide(/)
                // as well as the operator on top of the operator stack being either a plus(+)
                // or minus(-), then push the regular operator at this index onto the operator stack
                if ((op.isEmpty() || op.opStack.top().getSymbol() == Symbol.LEFT_BRACKET)
                    || ((op.opStack.top().getSymbol() == Symbol.PLUS
                        || op.opStack.top().getSymbol() == Symbol.MINUS)
                        && (splitExpression[i].equals("*") || splitExpression[i].equals("/")))) {
                  for (Symbol symbols : Symbol.values()) {
                    if (symbols.toString().equals(splitExpression[i])) {
                      op.push(symbols);
                    }
                  }
                  loop = false;
                } else {
                  // and doesn't satisfy the other conditions above, pop the operator stack and push
                  // the popped operator onto the string stack, repeat this process until the above
                  // conditions are satisfied
                  str.push(op.pop().toString());
                }
              }
            } else {
              // If the index is anything else, then throw an error
              throw new InvalidExpressionException("INVALID EXPRESSION");
            }
        }
      }
    }
    // Anything left still on the operator stack, pop and push onto the string stack
    while (op.isEmpty() != true) {
      str.push(op.pop().toString());
    }
    String s = ""; // Pop all of the string stack into a string expression (will be in Postfix)
    while (str.isEmpty() != true) {
      s = str.pop() + " " + s;
    }
    RevPolishCalc calc = new RevPolishCalc();
    return calc.evaluate(s); // Pass the string into a postfix calculator and return the result
  }
}
