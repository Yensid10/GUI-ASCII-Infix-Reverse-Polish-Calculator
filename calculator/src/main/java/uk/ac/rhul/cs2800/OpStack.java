package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * A facade used to hide details of the stack class and make it so it only handles the enums Symbol.
 *
 * @author bensh
 */
public class OpStack {
  Stack opStack; // Only variable that isn't private since I call it in another class

  /**
   * A constructor that initialises the basic stack class needed.
   */
  public OpStack() {
    opStack = new Stack();
  }

  /**
   * Used to push an Entry class storing a passed in enum Symbol onto a stack.
   *
   * @param s the passed in enum Symbol
   */
  public void push(Symbol s) {
    Entry entry = new Entry(s);
    opStack.push(entry);
  }

  /**
   * Returns the enum Smybol being stored on top of the stack, unless the stack is empty, if so an
   * error is thrown.
   *
   * @return the enum Symbol being stored on top of the stack
   * @throws BadTypeException exception thrown when you try to get the value from an Entry but its
   *         storing a different type
   */
  public Symbol pop() throws BadTypeException {
    if (opStack.size() == 0) {
      throw new EmptyStackException();
    } else {
      return opStack.pop().getSymbol();
    }
  }

  /**
   * Used to check if the stack is empty or not.
   *
   * @return true if the stack is empty or false if it is not
   */
  public boolean isEmpty() {
    if (opStack.size() == 0) {
      return true;
    }
    return false;
  }

}
