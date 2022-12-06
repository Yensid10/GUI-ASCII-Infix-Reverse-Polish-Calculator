package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * @author bensh
 *
 */
public class CalcAscii implements ViewInterface {
  String answer;
  static Scanner scanner = new Scanner(System.in);
  boolean fix;
  CalcModel calculator;

  /**
   * 
   */
  public void terminalMenu() {
    calculator = new CalcModel();
    System.out.println("||||||||||||||||||||||||||");
    System.out.println("--------------------------");
    System.out.println("--------CALCULATOR--------");
    while (true) {
      String answer;
      try {
        answer = Float.toString(calculator.evaluate(getExpression(), getFix()));
      } catch (Exception e) {
        answer = "INVALID EXPRESSION";
      }
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
      String notation = scanner.nextLine().toUpperCase();
      if (!notation.equals("Y")) {
        System.out.println("--------------------------");
        System.out.println("||||||||||||||||||||||||||");
        System.exit(0);
      }
    }
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
