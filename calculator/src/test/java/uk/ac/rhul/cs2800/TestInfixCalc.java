package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestInfixCalc {

  InfixCalc calculator;

  @BeforeEach
  public void setup() {
    this.calculator = new InfixCalc(); // Creates an empty stack class for the tests to use
  }

  @Test // Test #1
  void test() {
    RevPolishCalc initialCalculator = null;
  }

  @Test // Test #2
  void additionTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 + 4"), 7,
        "With the expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer using addition should be 7");
  }

  @Test // Test #3
  void subtractionTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 - 4"), -1,
        "With the expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer using subtraction should be -1");
  }

  @Test // Test #4
  void multiplicationTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 * 4"), 12,
        "With the expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer using multiplication should be 12");
  }

  @Test // Test #5
  void divisionTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 / 4"), 0.75,
        "With the expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer using division should be 0.75");
  }

  @Test // Test #6
  void complexTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("7 + ( 8 * 3 + 4 )"), 35,
        "With the expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer should be 35");
  }

  @Test // Test #7
  void complexTest2() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("( 5 * ( 6 + 7 ) ) - 2"), 63,
        "With the expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer should be 63");
  }
  // precedence test & unbalanced brackets

}
