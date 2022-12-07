package uk.ac.rhul.cs2800;

/**
 * An interface to make sure calculator classes have the ability to evaluate an expression.
 *
 * @author bensh
 *
 */
public interface ModelInterface {
  /**
   * Evaluates a String expression into a float by parsing into a calculator algorithm.
   *
   * @param expression a string expression made up of an inputed mathematical expression
   * @return the evaluated float
   * @throws InvalidExpressionException exception thrown when an entered expression does not work
   *         with the calculators algorithm, meaning its an incorrect/unusable expression
   * @throws BadTypeExceptionan exception thrown when you try to get the value from an Entry but its
   *         storing a different type
   */
  public float evaluate(String expression) throws InvalidExpressionException, BadTypeException;
}
