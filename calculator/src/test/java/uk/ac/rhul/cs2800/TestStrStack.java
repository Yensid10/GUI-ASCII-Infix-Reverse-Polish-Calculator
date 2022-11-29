package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author bensh
 *
 */
class TestStrStack {
  StrStack strStack;


  @BeforeEach
  public void setup() {
    this.strStack = new StrStack(); // Creates an empty stack class for the tests to use
  }

  @Test // Test #1s
  void test() {
    StrStack initialStrStack = null;
  }

  @Test // Test #2
  void pushPopTest() throws BadTypeException {
    strStack.push("This is a test");
    assertEquals(strStack.pop(), "This is a test",
        "Push and then pop of a string should return the original string");
  }

  @Test // Test #3
  void emptyStackTest() throws BadTypeException {
    strStack.push("This is another test");
    assertEquals(strStack.pop(), "This is another test",
        "Push and then pop of a string should return the original string");
    assertThrows(EmptyStackException.class, () -> strStack.pop(),
        "Push, pop & pop will subsequently throw an exception.");
  }

  @Test // Test #4
  void isEmptyTest() throws BadTypeException {
    strStack.push("This is the final test");
    assertEquals(strStack.isEmpty(), false,
        "Push and then calling isEmpty should return false as the numStack is not empty");
    strStack.pop();
    assertEquals(strStack.isEmpty(), true,
        "Push, pop and then calling isEmpty should return true as the numStack is now empty");
  }
}
