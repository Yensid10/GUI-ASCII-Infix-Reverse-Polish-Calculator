package uk.ac.rhul.cs2800;

/**
 * @author bensh
 *
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
