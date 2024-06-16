package Controllers;
/* Name: Hoang Ngoc Quynh Anh
 Purpose: This game, called Soduku (female edition), includes five levels: easy, medium, hard, expert, and evil.
 The 6x6 sodoku game's easy and medium levels require players to fill in each row and column from 1 to 6.
 This level is intended for novices and features a smaller grid that is simpler to understand and solve.
 If you're new to Sudoku or just want a short and entertaining challenge, this is ideal for you.
 On the other hand, level hard, expert, evil is a 9x9 sodoku game designed for players who want to push their mental
 limits and find it somewhat more difficult to complete the puzzles. Players must fill each row and column from 1 to 9.
*/
import Model.navigationManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class mainPageController {

    @FXML
    private Button btn_newGame;
    private navigationManager NavigationManager;
    public mainPageController(){
        this.NavigationManager = navigationManager.getInstance();
    }

public void navigation(String fxml, ActionEvent actionEvent) throws IOException {
    Parent parent =
            FXMLLoader.load(getClass().getResource(fxml));
    Scene scene = new Scene(parent);
    NavigationManager.navigateTo(scene);

}

    @FXML
    void btn_newGame(ActionEvent actionEvent) throws IOException {
        navigation("/static/level.fxml",actionEvent);


    }

}
