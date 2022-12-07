package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
  // This was made as the main RevPolishCalc class to test and initialise after Test #1
  RevPolishCalc calculator;

  @BeforeEach
  public void setup() {
    this.calculator = new RevPolishCalc(); // Creates an initialised RevPolishCalc class
  }

  @Test // Test #1
  // This test is just used to help create the initial TDD constructor and show the test succeeding
  void test() {
    @SuppressWarnings("unused")
    RevPolishCalc initialCalculator = null;
  }

  @Test // Test #2
  // I decided that I'd test addition first (it would be either addition or multiplication due to
  // the ease of their expression in the RevPolishCalc class), which after the algorithms completion
  // produced a successful result
  void additionTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 4 +"), 7,
        "With the expression given being in Reverse Polish Notation, the resulting arithmatic "
            + "returned answer using addition should be 7");
  }

  @Test // Test #3
  // Since I initially had errors for this test, I had to rework my original class to account for
  // what order the numbers are output from the stack, after this was handled the test ran
  // successfully
  void subtractionTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 4 -"), -1,
        "With the expression given being in Reverse Polish Notation, the resulting arithmatic "
            + "returned answer using subtraction should be -1");
  }

  @Test // Test #4
  // A test to see if two float numbers passed in and a times operator would multiply correctly
  void multiplicationTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 4 *"), 12,
        "With the expression given being in Reverse Polish Notation, the resulting arithmatic "
            + "returned answer using multiplication should be 12");
  }

  @Test // Test #5
  // Same problem as subtraction, but after fixing successfully displays the division between two
  // floats
  void divisionTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 4 /"), 0.75,
        "With the expression given being in Reverse Polish Notation, the resulting arithmatic "
            + "returned answer using division should be 0.75");
  }

  @Test // Test #6
  // A more varied and complex expression was passed in, to see if could handle all operators
  void complexTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 9 4 5 / * 12 + -"), -16.2f,
        "With the expression given being in Reverse Polish Notation, the resulting arithmatic "
            + "returned answer should be -16.2");
  }

  @Test // Test #7
  // An expression full of letters is passed into the calculator, which should result in an error,
  // its either this or an EmptyStack exception if an incorrect expression is entered, which my
  // Calculator views account for.
  void exceptionTest() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("ab c d"),
        "When entering letters into the calculator expression, it should return an Invalid-"
            + "-ExpressionException");
  }

  @Test // Test #8
  // This is testing the EmptyStack exception by adding an incorrect expression that throws it
  void emptyStackExceptionTest() throws EmptyStackException {
    assertThrows(EmptyStackException.class, () -> calculator.evaluate("+ + 3 3 4"),
        "When entering a specific incorrect expression into the calculator , it should return "
            + "an EmptyStackException");
  }

  @Test // Test #9
  // After performing system tests, I encountered an error within my infix calculator, that caused
  // incorrect code to produce a result (described in more detail within TestInfixcalc), this is the
  // Postfix representation of the expression that caused the error, and the proof that the code now
  // throws an error for it
  void systemTestingTest() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("1 3 - 4 5 +"),
        "When performing system testing with Infix notation");
  }
}
