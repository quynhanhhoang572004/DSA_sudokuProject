/* Name: Hoang Ngoc Quynh Anh
 Purpose: This game, called Soduku (female edition), includes five levels: easy, medium, hard, expert, and evil.
 The 6x6 sodoku game's easy and medium levels require players to fill in each row and column from 1 to 6.
 This level is intended for novices and features a smaller grid that is simpler to understand and solve.
 If you're new to Sudoku or just want a short and entertaining challenge, this is ideal for you.
 On the other hand, level hard, expert, evil is a 9x9 sodoku game designed for players who want to push their mental
 limits and find it somewhat more difficult to complete the puzzles. Players must fill each row and column from 1 to 9.
*/
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
    public void navigation(String fxml, ActionEvent actionEvent) throws IOException {
        Parent parent =
                FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(parent);
        navigationManager.navigateTo(scene);
    }

        @FXML
        void btn_newGame(ActionEvent actionEvent) throws IOException {
          navigation("/static/MainPage.fxml",actionEvent);

        }

        @FXML
        void btn_try_again(ActionEvent actionEvent) throws IOException {
          navigation("/static/level.fxml",actionEvent);

        }

    @FXML
    void btn_back(ActionEvent event) {
        navigationManager.goBack();
    }

    @FXML
    void btn_forward(ActionEvent event) {
        navigationManager.goForwrad();

    }



}
