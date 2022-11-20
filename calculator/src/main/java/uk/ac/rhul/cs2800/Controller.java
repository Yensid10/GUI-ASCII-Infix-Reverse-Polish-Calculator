package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * @author bensh
 *
 */
public class Controller {

  /**
   * @param args
   */
  public static void main(String[] args) {
    if (System.console() == null) {
      GuiDriver.main(args);
    } else { //Can't figure out how to get this to work properly yet...
      terminalMenu();
    }
  }

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
    String expression = scanner.next();
    if (notation.equals("I")) {
      // call infix
    } else {
      // call reverse polish
    }
  }

}
