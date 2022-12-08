package uk.ac.rhul.cs2800;

/**
 * Model used to control the calculators and determine which one is being called, returns an answer.
 *
 * @author bensh
 */
public class CalcModel {
  private RevPolishCalc revPolishCalc;
  private InfixCalc infixCalc;

  /**
   * A constructor that initialises instances of each calculator.
   */
  public CalcModel() {
    revPolishCalc = new RevPolishCalc();
    infixCalc = new InfixCalc();
  }

  /**
   * A called function used to evaluate a given expression from notation into a float result.
   *
   * @param expression a string expression made up of an inputed mathematical expression
   * @param isPostfix a boolean that is true if the Reverse Polish calculator is needed or false if
   *        the Infix calculator is needed
   * @return the evaluated float
   * @throws InvalidExpressionException exception thrown when an entered expression does not work
   *         with the calculators algorithm, meaning its an incorrect/unusable expression
   * @throws BadTypeException exception thrown when you try to get the value from an Entry but its
   *         storing a different type
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
