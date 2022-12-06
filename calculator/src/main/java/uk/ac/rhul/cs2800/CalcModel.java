package uk.ac.rhul.cs2800;

/**
 * @author bensh
 *
 */
public class CalcModel {
  RevPolishCalc revPolishCalc;
  InfixCalc infixCalc;

  public CalcModel() {
    revPolishCalc = new RevPolishCalc();
    infixCalc = new InfixCalc();
  }

  /**
   * @param expression
   * @param isPostfix
   * @return
   * @throws InvalidExpressionException
   * @throws BadTypeException
   */
  public float evaluate(String expression, Boolean isPostfix)
      throws InvalidExpressionException, BadTypeException {
    if (isPostfix == true) {
      return revPolishCalc.evaluate(expression);
    } else {
      return infixCalc.evaluate(expression);
    }
  }
}
