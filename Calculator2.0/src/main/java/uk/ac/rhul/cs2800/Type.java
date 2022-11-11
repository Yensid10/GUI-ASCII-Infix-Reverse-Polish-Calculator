package uk.ac.rhul.cs2800;

/**
 * An enum representing the different types of values that can be stored within an Entry class.
 *
 * @author bensh
 */
public enum Type {
  NUMBER("NUMBER"), SYMBOL("SYMBOL"), STRING("STRING"), INVALID("INVALID");

  private String typeString;

  private Type(String string) {
    this.typeString = string;
  }

  @Override
  public String toString() {
    return new String(typeString);
  }
}
