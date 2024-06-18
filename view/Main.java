package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    private final String JAVAFX_XML_PATH = "/resources/view/menu.fxml";
    private final String JAVAFX_CSS_PATH = "/resources/view/styles.css";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(JAVAFX_XML_PATH)));
        Scene scene = new Scene(root, 320, 400);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource(JAVAFX_CSS_PATH)).toExternalForm());
        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
