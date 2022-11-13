package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {

  Stack stack; // This was made as the main stack class to test and initialised after Test #1
  Entry entry; // Made as main entry class to be passed into the stack
  Random random = new Random(); // Creates a random class that's used to generate random integers

  // Add Before Each
  @BeforeEach
  public void setup() {
    this.stack = new Stack(); // Creates an empty stack class for the tests to use
  }

  @Test // Test #1
  // This test is just used to help create the constructor and show the test succeeding
  void test() {
    Stack initalStack = new Stack();
  }

  @Test // Test #2
  // I used an arrayList with Entry from the start (which had a blank Entry class stored inside), so
  // I had to use null values to check if it was being stored properly on less complex tests
  void pushTest() {
    Entry initialEntry = null;
    stack.push(initialEntry);
    assertEquals(stack.pop(), null,
        "An Entry with value null, pushed onto stack should be returned as null when popped");
  }

  @Test // Test #3
  // I started to use the public stack and entry classes I made here, along with writing a sequence
  // that would be able to test the exception needed for an empty stack
  void popTest() {
    entry = null;
    stack.push(entry);
    assertEquals(stack.pop(), null,
        "Test to see if a pushed entry will be returned if pop is called afterwards");
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "Push, pop & pop will subsequently throw an exception.");
  }

  @Test // Test #4
  // This checks to see if the top method works by using a sequence that should result in an
  // EmptyStackException and still return null
  void topTest() {
    entry = null;
    stack.push(entry);
    assertEquals(stack.top(), null,
        "Test to see if a pushed entry will be returned if top is called afterwards");
    stack.pop();
    assertThrows(EmptyStackException.class, () -> stack.top(),
        "Push, top & pop will subsequently throw an exception.");
  }

  @Test // Test #5
  // Pushes a few null entry classes onto a stack and see's if it returns the correct size
  void sizeTest() {
    entry = null;
    for (int x = 0; x < 28; x++) {
      stack.push(entry);
    }
    assertEquals(stack.size(), 28,
        "Test to see if the stacks size will return the correct quantity of Entries");
  }

  @Test // Test #6
  // These were made after the Entry class was coded to store values, this test should have a
  // sequence that will check properly if an initially stored value is returned correctly at the end
  void entryFloatTest() throws BadTypeException {
    entry = new Entry(382.0f);
    stack.push(entry);
    for (int x = 0; x < 2; x++) {
      entry = new Entry((float) random.nextInt(400));
      // These numbers could be anything, more used as proof of concept that it can store multiple
      // different float numbers inside the stack
      stack.push(entry);
    }
    assertEquals(stack.size(), 3,
        "Test to see if the stacks size will return the correct quantity");
    entry = stack.pop();
    assertEquals(entry.getType(), Type.NUMBER, "Test to see if the entry popped has Type NUMBER");
    stack.pop();
    assertEquals(stack.top().getValue(), 382.0f,
        "After pushing 3 times and popping twice, it should return the initially pushed number");
  }

  @Test // Test #7
  // The test will store a Symbol, push a bunch of float values, test multiple parts of the custom
  // BadTypeEexception, then test the enum Symbol's toString method, before finally seeing if the
  // EmpyStackException will still work
  void entrySymbolTest() throws BadTypeException {
    entry = new Entry(Symbol.PLUS);
    stack.push(entry);
    for (int x = 0; x < 4; x++) {
      entry = new Entry((float) random.nextInt(400));
      stack.push(entry);
    }
    assertEquals(stack.size(), 5,
        "Test to see if the stacks size will return the correct quantity");
    entry = stack.pop();
    assertThrows(BadTypeException.class, () -> entry.getSymbol(),
        "An entry returned by pop containing a float should throw a BadTypeException"
            + " if called to get symbol");
    entry = stack.pop();
    assertThrows(BadTypeException.class, () -> entry.getString(),
        "An entry returned by pop containing a float should throw a BadTypeException"
            + " if called to get string");
    stack.pop();
    stack.pop();
    assertEquals(stack.top().getSymbol().toString(), "+",
        "Returns the toString representation of a Symbol");
    assertEquals(stack.pop().getSymbol(), Symbol.PLUS,
        "After pushing 3 times and popping twice, it should return the initially pushed number, "
            + "whilst removing the final Entry from the stack");
    assertThrows(EmptyStackException.class, () -> stack.top(),
        "An empty stack should throw an exception if either top or pop is called");
  }

  @Test // Test #8
  // The final test stores a string value, then checks to see if the stack can store a larger value
  // of Entry's (1000+) and still return the correct size, as well as creating another stack and
  // comparing returned Entry values from both of them using hashcode & equals methods, before
  // finally seeing if the initially stored string is returned correctly
  void entryStringTest() throws BadTypeException {
    entry = new Entry("MAX"); // Doesn't have to be in all caps but I've chosen to do so
    stack.push(entry);
    for (int x = 0; x < 1080; x++) {
      entry = new Entry((float) random.nextInt(1000));
      stack.push(entry);
    }
    assertEquals(stack.size(), 1081,
        "Test to see if the stacks size will return the correct amount (even if large)");
    for (int x = 0; x < 1080; x++) {
      stack.pop(); // Removes the massive stack of random float Entry's
    }
    assertThrows(BadTypeException.class, () -> stack.top().getValue(),
        "An Entry storing a string, which is then pushed and popped multiple equal times, "
            + "should raise an exception when called to return a float");
    Stack stack2 = new Stack();
    Entry entry2 = new Entry("min");
    stack2.push(entry2);
    assertEquals(stack.top().equals(stack2.top()), false,
        "These two stacks calling their top entry and then calling equals should give false");
    assertEquals(stack.top().hashCode() == stack2.top().hashCode(), false,
        "These two stack calling their top entry and comparing the hash codes should give false");
    assertEquals(stack.pop().getString(), "MAX",
        "After pushing a string, then pushing and popping multiple floats,"
            + " a pop should return the initial string");
  }
}
