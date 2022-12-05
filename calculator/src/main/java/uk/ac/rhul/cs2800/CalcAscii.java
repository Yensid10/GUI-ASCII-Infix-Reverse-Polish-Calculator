package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * @author bensh
 *
 */
public class CalcAscii implements ViewInterface {
  static String expression;
  String answer;
  
  /**
   * 
   */
  public static void terminalMenu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("--------------------------");
    System.out.println("--------CALCULATOR--------");
    System.out.println("--------------------------");
    System.out.println("----DO YOU WANT TO USE----");
    System.out.println("---Infix|Reverse Polish---");
    System.out.println("--------TYPE(I/R)---------");
    System.out.println("--------------------------");
    String notation = "";
    while ((notation.equals("I") != true) && (notation.equals("R") != true)) {
      System.out.print("------------------------[");
      notation = scanner.next().toUpperCase();
      if ((notation.equals("I")) || (notation.equals("R"))) {
        continue;
      } else {
        System.out.println("-----PLEASE RE-ENTER------");
      }
    }
    System.out.println("-------PLEASE ENTER-------");
    System.out.println("--------EXPRESSION--------");
    System.out.print("--------[");
    expression = scanner.next();
    if (notation.equals("I")) {
      // call infix
    } else {
      // call reverse polish
    }
  }

  @Override
  public String getExpression() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setAnswer(String result) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean getFix() {
    // TODO Auto-generated method stub
    return false;
  }
}
