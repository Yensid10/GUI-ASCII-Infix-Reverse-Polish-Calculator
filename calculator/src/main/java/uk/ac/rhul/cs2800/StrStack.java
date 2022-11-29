package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * @author bensh
 *
 */
public class StrStack {
  Stack strStack;

  public StrStack() {
    strStack = new Stack();
  }

  public void push(String s) {
    Entry entry = new Entry(s);
    strStack.push(entry);
  }

  /**
   * 
   * @return
   * @throws BadTypeException
   */
  public String pop() throws BadTypeException {
    if (strStack.size() == 0) {
      throw new EmptyStackException();
    } else {
      return strStack.pop().getString();
    }
  }

  /**
   * 
   * @return
   */
  public boolean isEmpty() {
    if (strStack.size() == 0) {
      return true;
    }
    return false;
  }

}
