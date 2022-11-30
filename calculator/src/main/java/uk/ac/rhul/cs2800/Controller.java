package uk.ac.rhul.cs2800;

/**
 * @author bensh
 *
 */
public class Controller {
  //Model model;
  //View view;
  boolean isInfix;

  /**
   * @param args
   */
  public static void main(String[] args) {
    if (System.console() != null) {
      GuiDriver.main(args);
    } else { //Can't figure out how to get this to work properly yet...
      CalcAscii.terminalMenu();
    }
  }
}
