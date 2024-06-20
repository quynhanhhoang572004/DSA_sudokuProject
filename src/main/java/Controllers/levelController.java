/* Name: Hoang Ngoc Quynh Anh
 Purpose: This game, called Soduku (female edition), includes five levels: easy, medium, hard, expert, and evil.
 The 6x6 sodoku game's easy and medium levels require players to fill in each row and column from 1 to 6.
 This level is intended for novices and features a smaller grid that is simpler to understand and solve.
 If you're new to Sudoku or just want a short and entertaining challenge, this is ideal for you.
 On the other hand, level hard, expert, evil is a 9x9 sodoku game designed for players who want to push their mental
 limits and find it somewhat more difficult to complete the puzzles. Players must fill each row and column from 1 to 9.
*/
package Controllers;

import Model.SoundManager;
import Model.navigationManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class levelController implements Initializable {
    public static String level;
    private navigationManager NavigationManager;
    public levelController(){
        this.NavigationManager= navigationManager.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        level = null;
    }

    public void navigation(String fxml, ActionEvent actionEvent) throws IOException {
        Parent parent =
                FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(parent);
        NavigationManager.navigateTo(scene);
    }
    public void btn_easy(ActionEvent actionEvent) throws IOException {
        level = "Easy";
      navigation("/static/6x6_soduku.fxml",actionEvent);
    }

    public void btn_medium(ActionEvent actionEvent) throws IOException {
        level = "Medium";
        navigation("/static/6x6_soduku.fxml",actionEvent);
    }

    public void btn_hard(ActionEvent actionEvent) throws IOException {
        level = "Hard";
        navigation("/static/sudoku.fxml",actionEvent);
    }

    public void btn_expert(ActionEvent actionEvent) throws IOException {
        level = "Expert";
        navigation("/static/sudoku.fxml",actionEvent);

    }

    public void btn_evil(ActionEvent actionEvent) throws IOException {
        level = "Evil";
        navigation("/static/sudoku.fxml",actionEvent);
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