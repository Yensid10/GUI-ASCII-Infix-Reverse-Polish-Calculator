package uk.ac.rhul.cs2800;

/**
 * An exception thrown when an entered expression does not work with a calculators algorithm,
 * meaning its an incorrect/unusable expression.
 *
 * @author bensh
 */
public class InvalidExpressionException extends Exception {
  private static final long serialVersionUID = 1L;

  /**
   * A super that will display the given error message passed into the constructor when the
   * exception is called.
   *
   * @param string passed into the constructor to be displayed if the exception is thrown
   */
  public InvalidExpressionException(String string) {
    super(string);
  }
}
