package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author bensh
 *
 */
class TestOpStack {
  OpStack opStacker;


  @BeforeEach
  public void setup() {
    this.opStacker = new OpStack(); // Creates an empty stack class for the tests to use
  }

  @Test // Test #1
  void test() {
    OpStack initialOpStack = null;
  }

  @Test // Test #2
  void pushPopTest() throws BadTypeException {
    opStacker.push(Symbol.PLUS);
    assertEquals(opStacker.pop(), Symbol.PLUS,
        "Push and then pop of Symbol enum PLUS should return true");
  }

  @Test // Test #3
  void emptyStackTest() throws BadTypeException {
    opStacker.push(Symbol.MINUS);
    assertEquals(opStacker.pop(), Symbol.MINUS,
        "Push and then pop of of Symbol enum PLUS should return true");
    assertThrows(EmptyStackException.class, () -> opStacker.pop(),
        "Push, pop & pop will subsequently throw an exception.");
  }

  @Test // Test #4
  void isEmptyTest() throws BadTypeException {
    opStacker.push(Symbol.RIGHT_BRACKET);
    assertEquals(opStacker.isEmpty(), false,
        "Push and then calling isEmpty should return false as the numStack is not empty");
    opStacker.pop();
    assertEquals(opStacker.isEmpty(), true,
        "Push, pop and then calling isEmpty should return true as the numStack is now empty");
  }
}
