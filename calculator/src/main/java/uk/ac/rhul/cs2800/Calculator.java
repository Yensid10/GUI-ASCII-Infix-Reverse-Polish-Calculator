package uk.ac.rhul.cs2800;

/**
 * @author bensh
 *
 */
public class Calculator {

  public static void main(String[] args) {
    if (System.console() == null) {
      GuiDriver.initiateGui(args);
    } else {
      CalcAscii.terminalMenu();
    }
  }
}
