package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class TicTacToeViewController {
  public Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
  public Button btnNewGame;
  public Label lblresult;
  ArrayList<Button> buttons = new ArrayList<Button>();
  Button button;
  boolean player = false;
  int zug = 1;

  void initialize() {
    buttons.add(btn1);
    buttons.add(btn2);
    buttons.add(btn3);
    buttons.add(btn4);
    buttons.add(btn5);
    buttons.add(btn6);
    buttons.add(btn7);
    buttons.add(btn8);
    buttons.add(btn9);
  }

  public void onBtnClick(ActionEvent actionEvent) {
    button = (Button) actionEvent.getSource();
    // System.out.println(button.getId());
    // button.setText("Click");

    initialize();
    paint();
    checkwin();
  }

  void paint() {
    if (player) {
      button.setText("X");
    } else {
      button.setText("O");
    }
    button.setDisable(true);
    player = !player;
    zug++;
  }

  void checkwin() {

    if (btn1.getText().equals(btn2.getText()) && btn1.getText().equals(btn3.getText()) && btn1.isDisabled()) {
      // System.out.println(button.getText() + " wins");
      lblresult.setText(btn1.getText() + " wins");
      setStyle("green", btn1, btn2, btn3);
      disableButtons();
    } else if (btn4.getText().equals(btn5.getText()) && btn4.getText().equals(btn6.getText()) && btn4.isDisabled()) {
      // System.out.println(button.getText() + " wins");
      lblresult.setText(btn4.getText() + " wins");
      setStyle("green", btn4, btn5, btn6);
      disableButtons();
    } else if (btn7.getText().equals(btn8.getText()) && btn7.getText().equals(btn9.getText()) && btn7.isDisabled()) {
      // System.out.println(button.getText() + " wins");
      lblresult.setText(btn7.getText() + " wins");
      setStyle("green", btn7, btn8, btn9);
      disableButtons();
    } else if (btn1.getText().equals(btn4.getText()) && btn1.getText().equals(btn7.getText()) && btn1.isDisabled()) {
      // System.out.println(button.getText() + " wins");
      lblresult.setText(btn1.getText() + " wins");
      setStyle("green", btn1, btn4, btn7);
      disableButtons();
    } else if (btn2.getText().equals(btn5.getText()) && btn2.getText().equals(btn8.getText()) && btn2.isDisabled()) {
      // System.out.println(button.getText() + " wins");
      lblresult.setText(btn2.getText() + " wins");
      setStyle("green", btn2, btn5, btn8);
      disableButtons();
    } else if (btn3.getText().equals(btn6.getText()) && btn3.getText().equals(btn9.getText()) && btn3.isDisabled()) {
      // System.out.println(button.getText() + " wins");
      lblresult.setText(btn3.getText() + " wins");
      setStyle("green", btn3, btn6, btn9);
      disableButtons();
    } else if (btn1.getText().equals(btn5.getText()) && btn1.getText().equals(btn9.getText()) && btn1.isDisabled()) {
      // System.out.println(button.getText() + " wins");
      lblresult.setText(btn1.getText() + " wins");
      setStyle("green", btn1, btn5, btn9);
      disableButtons();
    } else if (btn3.getText().equals(btn5.getText()) && btn3.getText().equals(btn7.getText()) && btn3.isDisabled()) {
      // System.out.println(button.getText() + " wins");
      lblresult.setText(btn3.getText() + " wins");
      setStyle("green", btn3, btn5, btn7);
      disableButtons();
    } else if (zug == 9) {
      // System.out.println("Unentschieden");
      lblresult.setText("Unentschieden");
    }
  }

  void disableButtons() {
    for (Button btn : buttons) {
      btn.setDisable(true);
    }
  }

  void enableButtons() {
    for (Button btn : buttons) {
      btn.setText("");
      btn.setDisable(false);
      setStyle("none", btn);
      lblresult.setText("");
    }
  }

  public void onBtnClickNewGame(ActionEvent actionEvent) {
    enableButtons();
  }

  void setStyle(String color, Button... buttons) {
    for (Button btn : buttons) {
      btn.setStyle("-fx-border-color: " + color);
    }
  }
}
