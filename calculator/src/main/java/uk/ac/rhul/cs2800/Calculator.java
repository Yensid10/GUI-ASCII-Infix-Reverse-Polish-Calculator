package uk.ac.rhul.cs2800;

/**
 * The main code that initiates the view assembly, which is subsequently linked to the model
 * assembly.
 *
 * @author bensh
 */
public class Calculator {

  /**
   * The main method being run, will display ASCII view if executed from a console, with any other
   * method of access displaying the JavaFx view.
   *
   * @param args command line arguments passed into the initial main method
   */
  public static void main(String[] args) {
    if (System.console() == null) { //Will return null if not accessed from a console
      GuiDriver.initiateGui(args);
    } else {
      CalcAscii ascii = new CalcAscii();
      ascii.terminalMenu();
    }
  }
}
