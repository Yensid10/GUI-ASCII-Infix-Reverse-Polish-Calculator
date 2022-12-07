package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {
  StrStack strStack; // This was made as the main StrStack class to test and initialise after Test#1


  @BeforeEach
  public void setup() {
    this.strStack = new StrStack(); // Creates an empty stack class for the tests to use
  }

  @Test // Test #1s
  // This test is just used to help create the initial TDD constructor and show the test succeeding
  void test() {
    @SuppressWarnings("unused")
    StrStack initialStrStack = null;
  }

  @Test // Test #2
  // I created and tested both push and pop together since pushing something to the NumStack is
  // useless if you can't pop it and vice-versa
  void pushPopTest() throws BadTypeException {
    strStack.push("This is a test");
    assertEquals(strStack.pop(), "This is a test",
        "Push and then pop of a string should return the original string");
  }

  @Test // Test #3
  // Checks to see if after a push and two pops (equivalent of pop'ing an empty stack), a java.util
  // exception is thrown
  void emptyStackTest() throws BadTypeException {
    strStack.push("This is another test");
    assertEquals(strStack.pop(), "This is another test",
        "Push and then pop of a string should return the original string");
    assertThrows(EmptyStackException.class, () -> strStack.pop(),
        "Push, pop & pop will subsequently throw an exception.");
  }

  @Test // Test #4
  // Checks to see if after a push, the method isEmpty will return false and if after a subsequent
  // pop, the isEmpty called on the empty stack will return true
  void isEmptyTest() throws BadTypeException {
    strStack.push("This is the final test");
    assertEquals(strStack.isEmpty(), false,
        "Push and then calling isEmpty should return false as the numStack is not empty");
    strStack.pop();
    assertEquals(strStack.isEmpty(), true,
        "Push, pop and then calling isEmpty should return true as the numStack is now empty");
  }
}
