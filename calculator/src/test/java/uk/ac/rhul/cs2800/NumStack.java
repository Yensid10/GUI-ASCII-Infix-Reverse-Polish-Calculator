package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class NumStack {
  Stack numStack;

  public NumStack() {
    numStack = new Stack();
  }

  public void push(float f) {
    Entry entry = new Entry(f);
    numStack.push(entry);
  }

  public Float pop() throws BadTypeException {
    if (numStack.size() == 0) {
      throw new EmptyStackException();
    } else {
      return numStack.pop().getValue();
    }
  }

}
