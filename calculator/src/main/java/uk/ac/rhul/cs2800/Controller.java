package uk.ac.rhul.cs2800;

/**
 * @author bensh
 *
 */
public class Controller {
  final CalcModel calcMod = new CalcModel();
  ViewInterface calcView = null;
  boolean isPostfix;

  public void calculate() throws InvalidExpressionException, BadTypeException {
    float answer = calcMod.evaluate(calcView.getExpression(), calcView.getFix());
    calcView.setAnswer(answer);
  }

  // @Override
  // public void createView(ViewInterface view) {
  // calcView = view;
  // view.addObserver(() -> {
  // try {
  // calculate();
  // } catch (InvalidExpressionException | BadTypeException e) {
  // e.printStackTrace();
  // }
  // });
  // }

//  public Controller(ViewInterface view) {
//    createView(view);
//  }

  public Controller() {}

  // /**
  // * @param args
  // */
  // public static void main(String[] args) {
  // if (System.console() == null) {
  // calcView = new CalcView(true);
  // } else {
  // calcView = new CalcView(false);
  // }

  // if (System.console() != null) {
  // GuiDriver.main(args);
  // } else { //Can't figure out how to get this to work properly yet...
  // CalcAscii.terminalMenu();
  // }

  // }
}
