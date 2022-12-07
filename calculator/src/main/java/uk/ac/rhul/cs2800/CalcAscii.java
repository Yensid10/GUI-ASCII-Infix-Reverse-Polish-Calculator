package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * An Ascii view for the calculator.
 *
 * @author bensh
 */
public class CalcAscii implements ViewInterface {
  // A scanner to receive user input among multiple different functions
  private static Scanner scanner = new Scanner(System.in);

  /**
   * A menu for the ASCII view that provides answers to given expressions & repeats if prompted.
   */
  public void terminalMenu() {
    // Initiates an instance of the CalcModel used to evaluate given expressions
    CalcModel calculator = new CalcModel();
    String answer; // Used to store the answer output by the calculator or an error message

    System.out.println("||||||||||||||||||||||||||"); // My style of a console based calculator
    System.out.println("--------------------------");
    System.out.println("--------CALCULATOR--------");

    String loopCheck = "Y"; // Initiates the while loop that can let users run multiple calculations
    while (loopCheck.equals("Y")) {
      try { // Checks using error-validation that the result we get from our CalcModel is a float
        answer = Float.toString(calculator.evaluate(getExpression(), getFix()));
      } catch (Exception e) { // If not, then an exception is thrown and answer changed to INVALID
        answer = "INVALID EXPRESSION";
      }
      // Since float mathematical errors return Float.POSITIVE_INFINITY for the constraints given,
      // & is then converted into the string "infinity", we check this & change answer to MATH ERROR
      if (answer == "Infinity") {
        answer = "MATHS ERROR";
      }
      System.out.println("--------------------------");
      setAnswer(answer);
      System.out.println("--------------------------");
      System.out.println("-DO YOU WANT TO USE AGAIN-");
      System.out.println("--------TYPE(Y/??)--------");
      System.out.println("--------------------------");
      System.out.print("--------[");
      loopCheck = scanner.nextLine().toUpperCase(); // If anything other then "y" (yes), end loop
    }
    System.out.println("--------------------------");
    System.out.println("||||||||||||||||||||||||||");
    System.exit(0); // Fully exits console
  }

  @Override
  public String getExpression() {
    System.out.println("--------------------------");
    System.out.println("-------PLEASE ENTER-------");
    System.out.println("--------EXPRESSION--------");
    System.out.println("--------------------------");
    System.out.print("-------[");
    String expression = scanner.nextLine();
    return expression;
  }

  @Override
  public void setAnswer(String result) {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("--------------------------");
    System.out.println("-------A N S W E R--------");
    System.out.println("-------[" + result);
    System.out.println("--------------------------");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  @Override
  public boolean getFix() {
    System.out.println("--------------------------");
    System.out.println("----DO YOU WANT TO USE----");
    System.out.println("---Infix|Reverse Polish---");
    System.out.println("--------TYPE(I/P)---------");
    System.out.println("--------------------------");
    // Usually I don't use while true but since I'd have to add useless boolean statements if
    // trying to populate the conditions for the while loop I'll keep it as it helps to verify a
    // correct notation type is chosen
    while (true) {
      System.out.print("-------[");
      String notation = scanner.nextLine().toUpperCase();
      switch (notation) {
        case "I":
          return false;
        case "P":
          return true;
        default:
          System.out.println("-----PLEASE RE-ENTER------");
      }
    }
  }
}
