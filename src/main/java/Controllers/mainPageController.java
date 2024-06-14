package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class mainPageController {

    @FXML
    private Button btn_newGame;
//    private void getSource(ActionEvent actionEvent) throws IOException {
//        Parent parent =
//                FXMLLoader.load(getClass().getResource("/static/level.fxml"));
//        Scene scene = new Scene(parent);
//        Stage stage =
//                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        navigationManager.navigateTo(scene);
//        stage.show();
//    }
public void navigation(String fxml, ActionEvent actionEvent) throws IOException {
    Parent parent =
            FXMLLoader.load(getClass().getResource(fxml));
    Scene scene = new Scene(parent);
    navigationManager.navigateTo(scene);
//    Stage stage =
//            (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//    stage.setScene(scene);
//    stage.show();

}

    @FXML
    void btn_newGame(ActionEvent actionEvent) throws IOException {
        navigation("/static/level.fxml",actionEvent);


    }

}
