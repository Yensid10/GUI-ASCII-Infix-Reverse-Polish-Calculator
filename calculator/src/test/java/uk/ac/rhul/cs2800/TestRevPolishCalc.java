package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
  RevPolishCalc calculator;

  @BeforeEach
  public void setup() {
    this.calculator = new RevPolishCalc(); // Creates an empty stack class for the tests to use
  }

  @Test // Test #1
  void test() {
    RevPolishCalc initialCalculator = null;
  }

  @Test // Test #2
  void additionTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 4 +"), 7,
        "With the expression given being in Reverse Polish Notation, the resulting arithmatic "
        + "returned answer using addition should be 7");
  }
  
  @Test // Test #3
  void subtractionTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 4 -"), -1,
        "With the expression given being in Reverse Polish Notation, the resulting arithmatic "
        + "returned answer using subtraction should be -1");
  }
  
  @Test // Test #4
  void multiplicationTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 4 *"), 12,
        "With the expression given being in Reverse Polish Notation, the resulting arithmatic "
        + "returned answer using multiplication should be 12");
  }
  
  @Test // Test #5
  void divisionTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 4 /"), 0.75,
        "With the expression given being in Reverse Polish Notation, the resulting arithmatic "
        + "returned answer using division should be 0.75");
  }
  
  @Test // Test #6
  void complexTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 9 4 5 / * 12 + +"), 22.2f,
        "With the expression given being in Reverse Polish Notation, the resulting arithmatic "
        + "returned answer should be 22.2");
  }
  
  @Test // Test #7
  void exceptionTest() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("ab c d"),
        "When entering letters into the calculator expression, it should return an Invalid-"
        + "-ExpressionException");
  }
  

}
