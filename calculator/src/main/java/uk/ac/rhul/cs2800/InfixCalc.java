package uk.ac.rhul.cs2800;

import java.util.regex.Pattern;

/**
 * @author bensh
 *
 */
public class InfixCalc implements CalcInterface {
  OpStack op;
  StrStack str;

  public InfixCalc() {
    op = new OpStack();
    str = new StrStack();
  }

  @Override
  public float evaluate(String expression) throws InvalidExpressionException, BadTypeException {
    String[] splitExpression = expression.split(" ");
    for (int i = 0; i < splitExpression.length; i++) {
      try {
        str.push(Float.toString(Float.parseFloat(splitExpression[i])));
      } catch (Exception e) {
        switch (splitExpression[i]) {
          case "(":
            op.push(Symbol.LEFT_BRACKET);
            break;
          case ")":
            while (op.opStack.top().getSymbol() != Symbol.LEFT_BRACKET) {
              str.push(op.pop().toString());
            }
            op.pop();
            break;
          default:
            if (splitExpression[i].equals("+") || splitExpression[i].equals("-")
                || splitExpression[i].equals("/") || splitExpression[i].equals("*")) {
              while (true) {
                if ((op.isEmpty() || op.opStack.top().getSymbol() == Symbol.LEFT_BRACKET)
                    || ((op.opStack.top().getSymbol() == Symbol.PLUS
                        || op.opStack.top().getSymbol() == Symbol.MINUS)
                        && (splitExpression[i].equals("*") || splitExpression[i].equals("/")))) {
                  for (Symbol symbols : Symbol.values()) {
                    if (symbols.toString().equals(splitExpression[i])) {
                      op.push(symbols);
                    }
                  }
                  break;
                } else {
                  str.push(op.pop().toString());
                }
              }
            } else {
              throw new InvalidExpressionException("INVALID EXPRESSION");
            }
        }
      }
    }
    while (op.isEmpty() != true) {
      str.push(op.pop().toString());
    }
    String s = "";
    while (str.isEmpty() != true) {
      s = str.pop() + " " + s;
    }
    RevPolishCalc calc = new RevPolishCalc();
    return calc.evaluate(s);
  }
}
