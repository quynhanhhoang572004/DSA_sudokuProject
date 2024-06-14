package Controllers;
/* Name: Hoang Ngoc Quynh Anh
 Purpose:.
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/static/MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 604, 591);
        stage.setTitle("Soduku Girls edition");
        stage.setResizable(true);
        stage.setScene(scene);
        navigationManager.initialize(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}