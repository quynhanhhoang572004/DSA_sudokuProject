package Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOverController {

        @FXML
        void btn_newGame(ActionEvent actionEvent) throws IOException {
            Parent parent =
                    FXMLLoader.load(getClass().getResource("/static/MainPage.fxml"));
            Scene scene = new Scene(parent);
            Stage stage =
                    (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }

        @FXML
        void btn_try_again(ActionEvent actionEvent) throws IOException {
            Parent parent =
                    FXMLLoader.load(getClass().getResource("/static/level.fxml"));
            Scene scene = new Scene(parent);
            Stage stage =
                    (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();



        }



}
