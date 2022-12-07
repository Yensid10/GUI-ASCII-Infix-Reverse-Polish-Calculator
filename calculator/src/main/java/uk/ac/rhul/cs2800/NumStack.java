package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * A facade used to hide details of the stack class and make it so it only handles floats.
 *
 * @author bensh
 */
public class NumStack {
  Stack numStack;

  /**
   * A constructor that initialises the basic stack class needed.
   */
  public NumStack() {
    numStack = new Stack();
  }

  /**
   * Used to push an Entry class storing a passed in float onto a stack.
   *
   * @param f the passed in float
   */
  public void push(float f) {
    Entry entry = new Entry(f);
    numStack.push(entry);
  }

  /**
   * Returns the float value being stored on top of the stack, unless the stack is empty, if so an
   * error is thrown.
   *
   * @return the float value being stored on top of the stack
   * @throws BadTypeException exception thrown when you try to get the value from an Entry but its
   *         storing a different type
   */
  public Float pop() throws BadTypeException {
    if (numStack.size() == 0) {
      throw new EmptyStackException();
    } else {
      return numStack.pop().getValue();
    }
  }
  // Removed isEmpty as it was never utilised
  // I tried to make an interface for the stacks but since they all have to deal with different data
  // types and that would've involved me naming returns or passed in arguments as objects, I thought
  // it was better to write separate JavaDocs for them all
}
