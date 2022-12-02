package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * @author bensh
 *
 */
public class OpStack {
  Stack opStack;

  public OpStack() {
    opStack = new Stack();
  }

  public void push(Symbol s) {
    Entry entry = new Entry(s);
    opStack.push(entry);
  }

  /**
   * 
   * @return
   * @throws BadTypeException
   */
  public Symbol pop() throws BadTypeException {
    if (opStack.size() == 0) {
      throw new EmptyStackException();
    } else {
      return opStack.pop().getSymbol();
    }
  }

  /**
   * 
   * @return
   */
  public boolean isEmpty() {
    if (opStack.size() == 0) {
      return true;
    }
    return false;
  }

}
