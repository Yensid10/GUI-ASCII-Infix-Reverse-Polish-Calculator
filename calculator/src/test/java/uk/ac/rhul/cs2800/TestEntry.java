package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestEntry {
  Entry entry; // Created as main entry class to be initialised within each test
  Entry entry2; // Created to help with the comparative methods (equals & hashcode)

  // Don't need a before each since you need to directly add into the entry every time you call it

  @Test // Test #1
  // This test is just used to help create the constructor and show the test succeeding
  void test() {
    Entry initialEntry = null;
  }

  @Test // Test #2
  // Checks to see if the float constructor works (can't check the values inside yet since they're
  // private)
  void intTest() {
    entry = new Entry(1.0f);
  }

  @Test // Test #3
  // Checks to see if a new constructor can store an enum value, the enum is currently empty so null
  // is used
  void symbolTest() {
    Symbol symbol = null;
    entry = new Entry(symbol);
  }

  @Test // Test #4
  // Checks to see if a constructor can store a String value
  void stringTest() {
    entry = new Entry("Hello World");
  }

  @Test // Test #5
  // Putting a float in the Entry constructor and checking all the getters are returning the correct
  // values or throwing the correct exception
  void gettersFloatTest() throws BadTypeException {
    entry = new Entry(1.0f);
    assertEquals(entry.getType(), Type.NUMBER, "The float entry should return a Type NUMBER");
    assertThrows(BadTypeException.class, () -> entry.getString(),
        "Calling get string when entry is storing a float will throw an exception");
    assertThrows(BadTypeException.class, () -> entry.getSymbol(),
        "Calling get symbol when entry is storing a float will throw an exception");
    assertEquals(entry.getValue(), 1.0f,
        "The float should return the initially passed float number");
  }

  @Test // Test #6
  // Putting a string in the Entry constructor and checking all the getters are returning the
  // correct values or throwing the correct exception
  void gettersStringTest() throws BadTypeException {
    entry = new Entry("Hello World");
    assertEquals(entry.getType(), Type.STRING, "The string entry should return a Type STRING");
    assertEquals(entry.getString(), "Hello World",
        "The string entry should return the string initially entered");
    assertThrows(BadTypeException.class, () -> entry.getSymbol(),
        "Calling get symbol when entry is storing a string will throw an exception");
    assertThrows(BadTypeException.class, () -> entry.getValue(),
        "Calling get value when entry is storing a string will throw an exception");
  }

  @Test // Test #7
  // Putting a string in the Entry constructor and checking all the getters are returning the
  // correct values or throwing the correct exception
  void gettersSymbolMethod() throws BadTypeException {
    entry = new Entry(Symbol.RIGHT_BRACKET);
    assertEquals(entry.getType(), Type.SYMBOL, "The symbol entry should return a Type SYMBOL");
    assertThrows(BadTypeException.class, () -> entry.getString(),
        "Calling get string when entry is storing a symbol will throw an exception");
    assertEquals(entry.getSymbol(), Symbol.RIGHT_BRACKET,
        "The symbol entry should return the symbol initally entered");
    assertThrows(BadTypeException.class, () -> entry.getValue(),
        "Calling get value when entry is storing a symbol will throw an exception");
  }

  @Test // Test #8
  // Test to see if the toString methods for enums return the correct strings
  void enumToStrings() throws BadTypeException {
    entry = new Entry(Symbol.RIGHT_BRACKET);
    assertEquals(entry.getSymbol().toString(), ")",
        "An entry class storing a specific symbol, "
            + "when called to get said symbol it should display the correct symbol "
            + "using the toString method");
    entry = new Entry(2022.0f);
    assertEquals(entry.getType().toString(), "NUMBER",
        "An entry class storing a specific float, "
            + "when called to get the floats type should display the correct typing "
            + "of the float with the toString method");
  }

  @Test // Test #9
  // Testing to see if the equals and hashcode methods work for the Symbol class by using a second
  // entry class
  void equalsHashSymbolTest() {
    entry = new Entry(Symbol.RIGHT_BRACKET);
    entry2 = new Entry(Symbol.LEFT_BRACKET);
    assertEquals(entry.equals(entry2), false,
        "The two entries should return false when equals is called");
    assertEquals(entry2.hashCode() == entry.hashCode(), false,
        "The two entry classes, when called for the method hashCode, "
            + "should return different values");
    entry = new Entry(Symbol.LEFT_BRACKET);
    assertEquals(entry2.equals(entry), true,
        "The two entries should be storing the same symbol value so equals should return true");
    assertEquals(entry2.hashCode() == entry.hashCode(), true,
        "The two entry classes, when called for the method hashCode, should return the same value");
  }

  @Test // Test #10
  // Testing to see if the equals and hashcode methods work for the Float class by using a second
  // entry class and also testing if Entry can store large float numbers
  void equalsFloatTest() {
    entry = new Entry(999990234752439875290345724572970.0f);
    entry2 = new Entry(10000000000000000000000000000000.0f);
    assertEquals(entry.equals(entry2), false,
        "The two entries should return false when equals is called");
    assertEquals(entry2.hashCode() == entry.hashCode(), false,
        "The two entry classes, when called for the method hashCode, "
            + "should return different values");
    entry = new Entry(10000000000000000000000000000000.0f);
    assertEquals(entry2.equals(entry), true,
        "The two entries should be storing the same symbol value so equals should return true");
    assertEquals(entry2.hashCode() == entry.hashCode(), true,
        "The two entry classes, when called for the method hashCode, should return the same value");
    // Testing for these methods for Entry's containing a String is continued in the TestStack
  }
}
