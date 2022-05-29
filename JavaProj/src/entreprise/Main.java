package entreprise;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {
    private static Stage stg;

 @Override
 public void start(Stage primaryStage) throws Exception{
     stg = primaryStage;

 Parent root = FXMLLoader.load(getClass().getResource("entreprise.fxml"));
 primaryStage.setTitle("Crud java Salaries");
 primaryStage.setScene(new Scene(root, 800, 500));
 primaryStage.show();
 }
 public void changeScene(String fxml) throws IOException {
     Parent pane = FXMLLoader.load(getClass().getResource(fxml));
     stg.getScene().setRoot(pane);
 }
 public static void main(String[] args) {
 launch(args);
 }
}
