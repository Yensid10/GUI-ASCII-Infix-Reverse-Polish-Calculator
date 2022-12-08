package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Store's a stack of Entry values.
 *
 * @author bensh
 */
public class Stack {
  private int size; // Represents the count of Entry classes are stored within the array (stack)
  private ArrayList<Entry> entries; // An array that stores the Entry class

  /**
   * Creates a stack class and initialises the variables and array.
   */
  public Stack() {
    this.entries = new ArrayList<Entry>();
    this.size = 0; // The size of an empty stack will be set to 0
  }

  /**
   * Adds an Entry class to the array (Stack).
   *
   * @param entry an Entry class
   */
  public void push(Entry entry) {
    entries.add(entry);
    size++; // Size increases by 1 when you add an Entry to the array (Stack)
  }

  /**
   * Removes an Entry class from the array (Stack) and returns the value.
   *
   * @return a returned Entry class
   */
  public Entry pop() {
    if (size == 0) {
      throw new EmptyStackException(); // Thrown if size is 0 as there will be no Entry's stored
    }
    Entry entry = entries.get(size - 1);
    // Size will always be 1 larger since the index for the first pushed value starts at 0 (and size
    // would be 1) so minus 1 from size when calling the array (Stack) index
    entries.remove(size - 1);
    size--; // When an Entry is removed from the array (Stack), decrease size by 1
    return entry;
  }

  /**
   * Returns the value of the last entry in the array (Stack).
   *
   * @return a returned Entry class
   */
  public Entry top() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    Entry entry = entries.get(size - 1);
    return entry;
  }

  /**
   * Returns the amount of Entry entities in the Stack.
   *
   * @return the integer size of the array (Stack)
   */
  public int size() {
    return size;
  }
}
