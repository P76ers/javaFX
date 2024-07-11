package views;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;
import java.io.InputStream;

public class MyApplication extends Application {
  public static MyApplication instance;
  Stage primaryStage;
  BorderPane rootLayout;

  public static void run(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    this.primaryStage = primaryStage;
    instance = this;

    primaryStage.setTitle("My new App");
    primaryStage.setWidth(800);
    primaryStage.setHeight(600);
    primaryStage.setResizable(false);

    setIcon();
    // createScene();
    initRootLayout();
    loadView("WelcomeScene");
    primaryStage.show();
  }

  void setIcon() {
    InputStream iconStream = getClass().getResourceAsStream("/images/logo.png");
    Image image = new Image(iconStream);
    primaryStage.getIcons().add(image);
  }

  void createScene() {
    Label helloWorldLable = new Label("Hello World");
    helloWorldLable.setAlignment(Pos.CENTER);
    Scene primaryScene = new Scene(helloWorldLable);
    primaryStage.setScene(primaryScene);
  }

  public void loadView(String newView) throws IOException {
    String viewPath = "fxml/" + newView + ".fxml";

    rootLayout.getChildren().remove(rootLayout.getCenter()); // alle children löschen
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(viewPath));
    // MainSceneController mainSceneController = loader.getController();

    // Pane
    // AnchorPane anchorPane = loader.load();
    // Scene primaryScene = new Scene(anchorPane);
    // primaryStage.setScene(primaryScene);

    Pane pane = loader.load();
    rootLayout.setCenter(pane);

  }

  void initRootLayout() throws IOException {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("/views/fxml/MainView.fxml"));
      rootLayout = loader.load();
      Scene scene = new Scene(rootLayout);
      primaryStage.setScene(scene);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void shutdown() {
    int check = showConformation("My new App", "App beenden?", "ja=beenden | nein=abbrecchen");

    if (check == 1) {
      Platform.exit();
      System.exit(0);
    }
  }

  public static void showAboutBox() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("My Application");
    alert.setHeaderText("2024");
    alert.setContentText("MyInfo");
    alert.show();
  }

  public static int showConformation(String title, String headerText, String message) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
    alert.setTitle(title);
    alert.setHeaderText(headerText);
    alert.setContentText(message);
    alert.showAndWait();

    if (alert.getResult() == ButtonType.YES) {
      return 1;
    } else if (alert.getResult() == ButtonType.NO) {
      return 0;
    }
    return -1;
  }
}
