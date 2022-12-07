package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
  void bracketsTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("( 3 / 4 )"), 0.75,
        "With the expression given being in Infix Notation and using brackets correctly, "
            + "the resulting arithmatic returned answer using division should be 0.75");
  }

  @Test // Test #7
  void complexTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("7 + ( 8 * 3 + 4 )"), 35,
        "With the complicated expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer should be 35");
  }

  @Test // Test #8
  void complexTest2() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("( 5 * ( 6 + 7 ) ) - 2"), 63,
        "With the complicated expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer should be 63");
  }

  @Test // Test #9
  void exceptionTest() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("ab c d"),
        "When entering letters into the calculator expression, it should return an Invalid-"
            + "-ExpressionException");
  }

  @Test // Test #10
  void bracketExceptionTest() {
    assertThrows(Exception.class, () -> calculator.evaluate("( 4 + 5"),
        "When entering brackets incorrectly (unbalanced), an exception should be raised");
  }

  @Test // Test #11
  void bracketExceptionTest2() {
    assertThrows(Exception.class, () -> calculator.evaluate("4 + 5)"),
        "When entering brackets incorrectly (unbalanced), an exception should be raised");
  }

  @Test // Test #12
  void precedenceTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("5 * 6 + 7 - 2 / 4"), 36.5,
        "When being given an expression with just operators, it should perform the mathematical "
            + "calculations in the correct order to recive the correct answer/result");
  }

  @Test // Test #13
  void revPolishNotationTest() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("3 9 4 5 / * 12 + +"),
        "When entering Reverse Polish Notation into this calculator, it would still compute the "
            + "expression, after adding verification for this it should throw an exception if the "
            + "expression given is not in infix notation");
  }

  @Test // Test #13
  void systemTestingTest() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("( 1 - 3 ) 4 + 5"),
        "When entering Reverse Polish Notation into this calculator, it would still compute the "
            + "expression, after adding verification for this it should throw an exception if the "
            + "expression given is not in infix notation");
  }
}
