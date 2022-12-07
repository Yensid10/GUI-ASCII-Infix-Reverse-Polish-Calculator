package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * A facade used to hide details of the stack class and make it so it only handles Strings.
 *
 * @author bensh
 */
public class StrStack {
  Stack strStack;

  /**
   * A constructor that initialises the basic stack class needed.
   */
  public StrStack() {
    strStack = new Stack();
  }

  /**
   * Used to push an Entry class storing a passed in String onto a stack.
   *
   * @param s the passed in String
   */
  public void push(String s) {
    Entry entry = new Entry(s);
    strStack.push(entry);
  }

  /**
   * Returns the String value being stored on top of the stack, unless the stack is empty, if so an
   * error is thrown.
   *
   * @return the String value being stored on top of the stack
   * @throws BadTypeException exception thrown when you try to get the value from an Entry but its
   *         storing a different type
   */
  public String pop() throws BadTypeException {
    if (strStack.size() == 0) {
      throw new EmptyStackException();
    } else {
      return strStack.pop().getString();
    }
  }

  /**
   * Used to check if the stack is empty or not.
   *
   * @return true if the stack is empty or false if it is not
   */
  public boolean isEmpty() {
    if (strStack.size() == 0) {
      return true;
    }
    return false;
  }

}
