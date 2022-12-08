package uk.ac.rhul.cs2800;

/**
 * An enum representing the different types of mathematical operators found in a calculator.
 *
 * @author bensh
 */
public enum Symbol {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      "?"); // Sufficient visual representations of the mathematical operators

  private String visualSymbol;

  private Symbol(String string) {
    this.visualSymbol = string;
  }

  @Override
  public String toString() {
    return new String(visualSymbol);
  }
}
