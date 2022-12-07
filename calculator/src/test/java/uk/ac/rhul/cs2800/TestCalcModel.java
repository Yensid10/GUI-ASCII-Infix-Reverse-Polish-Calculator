package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {
  // This was made as the main InfixCalc class to test and initialise after Test #1
  CalcModel calcMod;

  @BeforeEach
  public void setup() {
    this.calcMod = new CalcModel(); // Creates an initialised CalcModel class for the tests to use
  }

  @Test // Test #1
  // This test is just used to help create the initial TDD constructor and show the test succeeding
  void test() {
    @SuppressWarnings("unused")
    CalcModel initialCalcModel = null;
  }

  @Test // Test #2
  // Testing that when a complex Postfix expression is entered into evaluate with isPostfix being
  // set to true, it should produce the correct result, and when its set to false, it should result
  // in an error. Also seeing if an incorrect equation being passed into evaluate and isPostfix is
  // set to true will still result in an error being thrown.
  void postfixTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calcMod.evaluate("3 9 4 5 / * 12 + +", true), 22.2f,
        "With the expression given being in Reverse Polish Notation, the resulting arithmatic "
            + "returned answer should be 22.2");
    assertThrows(InvalidExpressionException.class,
        () -> calcMod.evaluate("3 9 4 5 / * 12 + +", false),
        "With the expression given being in Reverse Polish Notation & isPostfix being set to false,"
            + " this should result in an error being thrown");
    assertThrows(InvalidExpressionException.class, () -> calcMod.evaluate("ab c d", true),
        "When entering letters into the calculator expression, it should return an Invalid-"
            + "-ExpressionException");
  }

  @Test // Test #2
  // Testing that when a complex Infix expression is entered into evaluate with isPostfix being
  // set to false, it should produce the correct result, and when its set to true, it should result
  // in an error.
  void infixTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calcMod.evaluate("3 + ( 9 * 4 / 5 + 12 )", false), 22.2f,
        "With the expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer should be 22.2");
    assertThrows(Exception.class,
        () -> calcMod.evaluate("3 + ( 9 * 4 / 5 + 12 )", true),
        "With the expression given being in Infix Notation & isPostfix being set to true,"
            + " this should result in an error being thrown");
  }
}
