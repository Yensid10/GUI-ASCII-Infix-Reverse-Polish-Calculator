package uk.ac.rhul.cs2800;

/**
 * An interface to make sure view classes have the ability to get the required data to call a
 * calculator model and display the answer given.
 *
 * @author bensh
 */
public interface ViewInterface {
  /**
   * Prompts the view to receive an inputed String expression.
   *
   * @return a string expression
   */
  public String getExpression();

  /**
   * Prompts the view to display a passed in String (this being the result of a previously passed in
   * expression once run through CalcModels evaluate method).
   *
   * @param result a string answer to a previous expression
   */
  public void setAnswer(String result);

  /**
   * Prompts the view to receive confirmation on what notation type the user wants the CalcModel to
   * account for.
   *
   * @return true if they want Reverse Polish, false if they want Infix
   */
  public boolean getFix();
}
