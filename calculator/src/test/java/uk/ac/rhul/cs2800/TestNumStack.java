package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {
  NumStack numStacker;


  @BeforeEach
  public void setup() {
    this.numStacker = new NumStack(); // Creates an empty stack class for the tests to use
  }

  @Test // Test #1
  void test() {
    NumStack initialNumStack = null;
  }

  @Test // Test #2
  void pushPopTest() throws BadTypeException {
    numStacker.push(382.0f);
    assertEquals(numStacker.pop(), 382.0f,
        "Push and then pop of a float number should return true");
  }

  @Test // Test #3
  void emptyStackTest() throws BadTypeException {
    numStacker.push(382.0f);
    assertEquals(numStacker.pop(), 382.0f,
        "Push and then pop of a float number should return true");
    assertThrows(EmptyStackException.class, () -> numStacker.pop(),
        "Push, pop & pop will subsequently throw an exception.");
  }

  @Test // Test #4
  void isEmptyTest() throws BadTypeException {
    numStacker.push(382.0f);
    assertEquals(numStacker.isEmpty(), false,
        "Push and then calling isEmpty should return false as the numStack is not empty");
    numStacker.pop();
    assertEquals(numStacker.isEmpty(), true,
        "Push, pop and then calling isEmpty should return true as the numStack is now empty");
  }
}
