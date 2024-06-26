package Controllers;

import Model.navigationManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class WinGameController {
    private navigationManager NavigationManager;
    public WinGameController(){
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