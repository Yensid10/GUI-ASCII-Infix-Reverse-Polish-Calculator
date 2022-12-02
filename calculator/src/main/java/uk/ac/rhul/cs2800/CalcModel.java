package uk.ac.rhul.cs2800;

/**
 * @author bensh
 *
 */
public class CalcModel {
  RevPolishCalc revPolishCalc;

  public CalcModel() {
    revPolishCalc = new RevPolishCalc();
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
      return 0;
    }
    
  }
}
