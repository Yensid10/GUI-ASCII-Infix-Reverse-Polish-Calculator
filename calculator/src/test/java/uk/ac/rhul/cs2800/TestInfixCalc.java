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
  void initialTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 + 4"), 7,
        "With the expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer using addition should be 7");
  }
  
  @Test // Test #3
  void complexTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("7 + ( 8 * 3 + 4 )"), 35,
        "With the expression given being in Infix Notation, the resulting arithmatic "
        + "returned answer should be 35");
  }
  
  @Test // Test #4
  void tester() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("( 5 * ( 6 + 7 ) ) - 2"), 63,
        "With the expression given being in Infix Notation, the resulting arithmatic "
        + "returned answer should be 63");
  }

}
