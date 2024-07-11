package controllers;


import views.MyApplication;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MainViewController {
  public void onMenuExitClick(ActionEvent actionEvent) {

    // app schliessen

    MyApplication.instance.shutdown();
  }

  public void menuBtnAboutClick(ActionEvent actionEvent) {
    MyApplication.showAboutBox();
  }

  public void onMnuBtnTicTacToeClick(ActionEvent actionEvent) throws IOException {
    MyApplication.instance.loadView("TicTacToeView");
  }
}
