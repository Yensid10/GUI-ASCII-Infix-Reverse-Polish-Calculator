package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * @author bensh
 *
 */
public class NumStack {
  Stack numStack;

  public NumStack() {
    numStack = new Stack();
  }

  public void push(float f) {
    Entry entry = new Entry(f);
    numStack.push(entry);
  }

  /**
   * 
   * @return
   * @throws BadTypeException
   */
  public Float pop() throws BadTypeException {
    if (numStack.size() == 0) {
      throw new EmptyStackException();
    } else {
      return numStack.pop().getValue();
    }
  }

  /**
   * 
   * @return
   */
  public boolean isEmpty() {
    if (numStack.size() == 0) {
      return true;
    }
    return false;
  }

}
