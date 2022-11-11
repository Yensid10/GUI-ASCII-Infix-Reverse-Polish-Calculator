package uk.ac.rhul.cs2800;

/**
 * An exception that is thrown when you're trying to retrieve the wrong type of value stored in an
 * Entry.
 *
 * @author bensh
 */
public class BadTypeException extends Exception {
  private static final long serialVersionUID = 1L;

  /**
   * A super that will display the given error message passed into the constructor when the
   * exception is called.
   *
   * @param string passed into the constructor to be displayed if the exception is thrown
   */
  public BadTypeException(String string) {
    super(string);
  }
}

