package uk.ac.rhul.cs2800;

import java.util.Objects;

/**
 * Stores values for a float, a string and 2 custom enums.
 *
 * @author bensh
 */
public class Entry {
  private float number; // Stores a float number
  private Symbol other; // Stores a value for the enum Symbol
  private String str; // Stores a string
  private Type type; // Stores a value of the enum Type

  /**
   * A constructor that takes a float value for the class and initialises it, then sets the type
   * value to NUMBER whilst setting all other stored values to default (null).
   *
   * @param value a passed in Float value
   */
  public Entry(float value) {
    this.number = value;
    this.str = null;
    // Non-passed values are set to a default (such as null) so they can be compared properly within
    // the equals method
    this.other = null;
    this.type = Type.NUMBER; // This represents what Type of value this Entry class is storing
  }

  /**
   * A constructor that takes an enum Symbol for the class and initialises it, then sets the type
   * value to SYMBOL whilst setting all other stored values to default.
   *
   * @param which a passed in enum Symbol value
   */
  public Entry(Symbol which) {
    this.number = 0.0f; // The default value for the float is just 0
    this.str = null;
    this.other = which;
    this.type = Type.SYMBOL;
  }

  /**
   * A constructor that takes a string value for the class and initialises it, then sets the type
   * value to STRING whilst setting all other stored values to default.
   *
   * @param string a passed in String value
   */
  public Entry(String string) {
    this.number = 0.0f;
    this.str = string;
    this.other = null;
    this.type = Type.STRING;
  }

  /**
   * Returns the stored type value.
   *
   * @return an instance of the enum Type
   */
  public Type getType() {
    return type;
  }

  /**
   * Uses the type parameter to see if there is a stored string (throws an exception if not) and
   * returns the string.
   *
   * @return a stored string value
   * @throws BadTypeException an exception thrown when you try to get the value from an Entry but
   *         its storing a different type
   */
  public String getString() throws BadTypeException {
    if (type != Type.STRING) {
      throw new BadTypeException("Currently storing " + type + ": tried to get string");
      // If the code is called to getString when the Entry is storing another value, throw this
      // exception and tell them what the Entry is storing
    }
    return str;
  }

  /**
   * Uses the type parameter to see if there is a stored enum Symbol (throws an exception if not)
   * and returns the Symbol.
   *
   * @return a stored enum Symbol
   * @throws BadTypeException an exception thrown when you try to get the value from an Entry but
   *         its storing a different type
   */
  public Symbol getSymbol() throws BadTypeException {
    if (type != Type.SYMBOL) {
      throw new BadTypeException("Currently storing " + type + ": tried to get symbol");
    }
    return other;
  }

  /**
   * Uses the type parameter to see if there is a stored float (throws an exception if not) and
   * returns the float.
   *
   * @return a stored float
   * @throws BadTypeException an exception thrown when you try to get the value from an Entry but
   *         its storing a different type
   */
  public Float getValue() throws BadTypeException {
    if (type != Type.NUMBER) {
      throw new BadTypeException("Currently storing " + type + ": tried to get float");
    }
    return number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, other, str, type);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Entry other = (Entry) obj;
    return Float.floatToIntBits(number) == Float.floatToIntBits(other.number)
        && this.other == other.other && Objects.equals(str, other.str) && type == other.type;
  }
}
