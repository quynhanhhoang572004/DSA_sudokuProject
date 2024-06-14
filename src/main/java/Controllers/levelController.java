package Controllers;

import Model.SoundManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class levelController implements Initializable {
    public static String level;
    private SoundManager soundManager;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        level = null;
    }

    public void navigation(String fxml, ActionEvent actionEvent) throws IOException {
        Parent parent =
                FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(parent);
        navigationManager.navigateTo(scene);
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