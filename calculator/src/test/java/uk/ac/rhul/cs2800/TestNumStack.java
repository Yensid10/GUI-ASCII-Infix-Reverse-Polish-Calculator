package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {
  NumStack numStack; // This was made as the main NumStack class to test and initialise after Test#1
  
  @BeforeEach
  public void setup() {
    this.numStack = new NumStack(); // Creates an empty NumStack class for the tests to use
  }

  @Test // Test #1
  // This test is just used to help create the initial TDD constructor and show the test succeeding
  void test() {
    @SuppressWarnings("unused")
    NumStack initialNumStack = null;
  }

  @Test // Test #2
  // I created and tested both push and pop together since pushing something to the NumStack is
  // useless if you can't pop it and vice-versa
  void pushPopTest() throws BadTypeException {
    numStack.push(382.0f);
    assertEquals(numStack.pop(), 382.0f,
        "Push and then pop of a float number should return true");
  }

  @Test // Test #3
  // Checks to see if after a push and two pops (equivalent of pop'ing an empty stack), a java.util
  // exception is thrown
  void emptyStackTest() throws BadTypeException {
    numStack.push(382.0f);
    assertEquals(numStack.pop(), 382.0f,
        "Push and then pop of a float number should return true");
    assertThrows(EmptyStackException.class, () -> numStack.pop(),
        "Push, pop & pop will subsequently throw an exception.");
  }
}
