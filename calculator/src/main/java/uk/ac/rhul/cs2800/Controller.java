package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class Controller {

  public static void main(String[] args) {
    if (System.console() == null) {
      GuiDriver.initiateGui(args);
    } else {
      terminalMenu();
    }
  }

  public static void terminalMenu() {
    String notation = null;
    String expression;
    Scanner scanner = new Scanner(System.in);
    System.out.println("--------------------------");
    System.out.println("--------CALCULATOR--------");
    System.out.println("--------------------------");
    System.out.println("----DO YOU WANT TO USE----");
    System.out.println("---Infix|Reverse Polish---");
    System.out.println("--------TYPE(I/R)---------");
    System.out.println("--------------------------");
    while ((notation.equals("I")) || (notation.equals("R"))) {
      System.out.print("------------------------[");
      notation = scanner.next().toUpperCase();
//      System.out.print("]------------");
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
      //call infix
    } else {
      //call reverse polish
    }
  }

}
