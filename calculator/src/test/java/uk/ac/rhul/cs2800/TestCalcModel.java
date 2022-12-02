package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {
  CalcModel calcMod;

  @BeforeEach
  public void setup() {
    this.calcMod = new CalcModel(); // Creates an empty stack class for the tests to use
  }

  @Test // Test #1
  void test() {
    CalcModel initialCalcModel = null;
  }

  @Test // Test #2
  void postfixTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calcMod.evaluate("3 9 4 5 / * 12 + +", true), 22.2f,
        "With the expression given being in Reverse Polish Notation, the resulting arithmatic "
            + "returned answer should be 22.2");
    assertThrows(InvalidExpressionException.class, () -> calcMod.evaluate("ab c d", true),
        "When entering letters into the calculator expression, it should return an Invalid-"
            + "-ExpressionException");
  }
}
