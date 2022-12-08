package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestInfixCalc {
  // This was made as the main InfixCalc class to test and initialise after Test #1
  private InfixCalc calculator;

  @BeforeEach
  public void setup() {
    this.calculator = new InfixCalc(); // Creates an initialised InfixCalc class
  }

  @Test // Test #1
  // This test is just used to help create the initial TDD constructor and show the test succeeding
  void test() {
    @SuppressWarnings("unused")
    RevPolishCalc initialCalculator = null;
  }

  @Test // Test #2
  // Since my first test in TestRevPolishCalc was addition, I show it passing here first
  void additionTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 + 4"), 7,
        "With the expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer using addition should be 7");
  }

  @Test // Test #3
  // A basic infix expression, involving minus, passed into this calculator will be evaluated
  // correctly
  void subtractionTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 - 4"), -1,
        "With the expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer using subtraction should be -1");
  }

  @Test // Test #4
  // A basic infix expression, involving times, passed into this calculator will be evaluated
  // correctly
  void multiplicationTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 * 4"), 12,
        "With the expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer using multiplication should be 12");
  }

  @Test // Test #5
  // A basic infix expression, involving divide, passed into this calculator will be evaluated
  // correctly
  void divisionTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("3 / 4"), 0.75,
        "With the expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer using division should be 0.75");
  }

  @Test // Test #6
  // Surrounding a previous expression with brackets should not affect the final result
  void bracketsTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("( 3 / 4 )"), 0.75,
        "With the expression given being in Infix Notation and using brackets correctly, "
            + "the resulting arithmatic returned answer using division should be 0.75");
  }

  @Test // Test #7
  // A more varied and complex expression was passed in, to see if could handle all operators,
  // including brackets and how that effects an equation/expression
  void complexTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("7 + ( 8 * 3 + 4 )"), 35,
        "With the complicated expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer should be 35");
  }

  @Test // Test #8
  // A more varied and complex expression was passed in, to see if could handle all operators,
  // including brackets and how that effects an equations/expressions final results
  void complexTest2() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("( 5 * ( 6 + 7 ) ) - 2"), 63,
        "With the complicated expression given being in Infix Notation, the resulting arithmatic "
            + "returned answer should be 63");
  }

  @Test // Test #9
  // An expression full of letters is passed into the calculator, which should result in an error
  void exceptionTest() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("ab c d"),
        "When entering letters into the calculator expression, it should return an Invalid-"
            + "-ExpressionException");
  }

  @Test // Test #10
  // Due to the nature of the algorithm used, it will throw an exception when the brackets are
  // unbalanced, shown here with a left bracket being unbalanced
  void leftBracketExceptionTest() {
    assertThrows(Exception.class, () -> calculator.evaluate("( 4 + 5"),
        "When entering brackets incorrectly (unbalanced), an exception should be raised");
  }

  @Test // Test #11
  // Due to the nature of the algorithm used, it will throw an exception when the brackets are
  // unbalanced, shown here with a right bracket being unbalanced
  void rightBracketExceptionTest() {
    assertThrows(Exception.class, () -> calculator.evaluate("4 + 5 )"),
        "When entering brackets incorrectly (unbalanced), an exception should be raised");
  }

  @Test // Test #12
  // Instead of giving each operator different distinct number values to compare their precedence to
  // each other, I formed logical conclusions and used an if statement instead that would account
  // for this, shown that even with all the operators listed in the expression below without any
  // specifically defined precedence, it still produces the correct result and passes the test
  void precedenceTest() throws InvalidExpressionException, BadTypeException {
    assertEquals(calculator.evaluate("5 * 6 + 7 - 2 / 4"), 36.5,
        "When being given an expression with just operators, it should perform the mathematical "
            + "calculations in the correct order to recieve the correct answer/result");
  }

  @Test // Test #13
  // When performing system testing, I encountered an error where when I input a Reverse Polish
  // notation expression but I'd selected it to run through the infix calculator, it would still
  // solve the expression. I assume this is because it would run through the expression given and
  // see that it matches all the criteria that is already laid out for it to convert any other
  // expression into. Since this is not the functionality I wanted for the calculator, I've added
  // verification to any expression passed into it, to make sure that it's Infix notation
  void revPolishNotationTest() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("3 9 4 5 / * 12 + +"),
        "When entering Reverse Polish Notation into this calculator, it would still compute the "
            + "expression, after adding verification for this it should throw an exception if the "
            + "expression given is not in infix notation");
  }

  @Test // Test #14
  // When performing more system testing, I encountered an error that caused an incorrect expression
  // to still produce a result instead of raising an error. This expression can be found below, and
  // whilst a human looking at it would assume anything next to a bracket is being times by it, for
  // the program, this shouldn't be accounted for and should result in an invalid expression. After
  // debugging both calculators, I realised it produced a Postfix expression that should be
  // unsolvable, but due to the nature of the Postfix algorithm, it was still computing. To stop
  // this, I added verification to the RevPolishcalc to make sure its Postfix notation, and tested
  // that with this same expression, it would cause an error instead of providing a result
  void systemTestingTest() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("( 1 - 3 ) 4 + 5"),
        "When entering an incorrect expression into the calculator, it should result in an error");
  }

  @Test // Test #15
  // Finally, when running a coverage test, I found the only thing I had not covered was for
  // checking if just one part of an expression is incorrect rather then the whole expression (such
  // as the alphabetical letters I entered above for Test #9), so I added the test for this below,
  // allowing for 100% coverage for everything tested within the Model Assembly.
  void coverageTesting() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("( 1 - 3 ) + a + 5"),
        "When entering an expression that satifies the major checks for being Infix but still is an"
            + "incorrect expression, this should fail to get through the minor verification check "
            + "and result in an error being thrown");
  }
}
