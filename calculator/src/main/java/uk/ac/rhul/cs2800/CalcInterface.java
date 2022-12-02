package uk.ac.rhul.cs2800;

/**
 * @author bensh
 *
 */
public interface CalcInterface {
  public float evaluate(String expression) throws InvalidExpressionException, BadTypeException;
}
