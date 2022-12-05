package uk.ac.rhul.cs2800;

/**
 * @author bensh
 *
 */
public class CalcView {
  CalcAscii ascii;
  GuiDriver gui;

  public static void main(String[] args) {
    if (System.console() == null) {
      GuiDriver.initiateGui(args);
    } else {
      CalcAscii.terminalMenu();
    }
  }
}
