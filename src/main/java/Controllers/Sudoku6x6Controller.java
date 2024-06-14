package Controllers;



import Model.SoundManager;
import Model.SudokuModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Sudoku6x6Controller implements Initializable {


    public TextField tf_3_1;
    public TextField tf_4_2;
    public TextField tf_4_1;
    public TextField tf_4_0;
    public TextField tf_5_2;
    public TextField tf_5_1;
    public TextField tf_5_0;
    public TextField tf_3_2;
    public TextField tf_3_0;
    public TextField tf_3_4;
    public TextField tf_4_5;
    public TextField tf_4_4;
    public TextField tf_4_3;
    public TextField tf_5_5;
    public TextField tf_5_4;
    public TextField tf_5_3;
    public TextField tf_3_5;
    public TextField tf_3_3;
    public TextField tf_0_1;
    public TextField tf_1_2;
    public TextField tf_1_1;
    public TextField tf_1_0;
    public TextField tf_2_2;
    public TextField tf_2_1;
    public TextField tf_2_0;
    public TextField tf_0_2;
    public TextField tf_0_0;

    public TextField tf_0_4;
    public TextField tf_1_5;
    public TextField tf_1_4;
    public TextField tf_1_3;
    public TextField tf_2_5;
    public TextField tf_2_4;
    public TextField tf_2_3;
    public TextField tf_0_5;
    public TextField tf_0_3;

    private int[][] i = new int[7][7];
    private int[][] ans = new int[7][7];

    public static String messageResult;
    private int counter;
    private SudokuModel model;
    private SoundManager soundManager;
    public Sudoku6x6Controller(){
        this.model = new SudokuModel();
        this.soundManager = new SoundManager();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        model.initializeGrids();
        model.setCounter(0);
        model.setMessageResult(null);
        setValue();

    }




    private void getUserInput() {
        i[0][0] = model.emptyChecker(tf_0_0.getText());
        i[0][1] = model.emptyChecker(tf_0_1.getText());
        i[0][2] = model.emptyChecker(tf_0_2.getText());
        i[0][3] = model.emptyChecker(tf_0_3.getText());
        i[0][4] = model.emptyChecker(tf_0_4.getText());
        i[0][5] = model.emptyChecker(tf_0_5.getText());

        i[1][0] = model.emptyChecker(tf_1_0.getText());
        i[1][1] = model.emptyChecker(tf_1_1.getText());
        i[1][2] = model.emptyChecker(tf_1_2.getText());
        i[1][3] = model.emptyChecker(tf_1_3.getText());
        i[1][4] = model.emptyChecker(tf_1_4.getText());
        i[1][5] = model.emptyChecker(tf_1_5.getText());

        i[2][0] = model.emptyChecker(tf_2_0.getText());
        i[2][1] = model.emptyChecker(tf_2_1.getText());
        i[2][2] = model.emptyChecker(tf_2_2.getText());
        i[2][3] = model.emptyChecker(tf_2_3.getText());
        i[2][4] = model.emptyChecker(tf_2_4.getText());
        i[2][5] = model.emptyChecker(tf_2_5.getText());

        i[3][0] = model.emptyChecker(tf_3_0.getText());
        i[3][1] = model.emptyChecker(tf_3_1.getText());
        i[3][2] = model.emptyChecker(tf_3_2.getText());
        i[3][3] = model.emptyChecker(tf_3_3.getText());
        i[3][4] = model.emptyChecker(tf_3_4.getText());
        i[3][5] = model.emptyChecker(tf_3_5.getText());

        i[4][0] = model.emptyChecker(tf_4_0.getText());
        i[4][1] = model.emptyChecker(tf_4_1.getText());
        i[4][2] = model.emptyChecker(tf_4_2.getText());
        i[4][3] = model.emptyChecker(tf_4_3.getText());
        i[4][4] = model.emptyChecker(tf_4_4.getText());
        i[4][5] = model.emptyChecker(tf_4_5.getText());

        i[5][0] = model.emptyChecker(tf_5_0.getText());
        i[5][1] = model.emptyChecker(tf_5_1.getText());
        i[5][2] = model.emptyChecker(tf_5_2.getText());
        i[5][3] = model.emptyChecker(tf_5_3.getText());
        i[5][4] = model.emptyChecker(tf_5_4.getText());
        i[5][5] = model.emptyChecker(tf_5_5.getText());

    }
        private void setValue() {
            Random random = new Random();

            int[] j1 = {1,2,3,4,5,6}; int p1 = 6;


            for(int a=0; a<=2; a++){
                for(int b=0; b<=2; b++){
                    if (p1>0){
                    int nn = random.nextInt(p1);
                    i[a][b] = j1[nn];
                    int sp = j1[nn];
                    j1[nn] = j1[p1-1];
                    j1[p1-1] = sp;
                    p1--;}

                }
            }

            //  part-2
            for(int a=0; a<=2; a++){
                int d = 0;
                for(int b=3; b<=5; b++){
                    if(a==2){
                        i[a][b] = i[0][d];
                        d++;
                    }else {
                        i[a][b] = i[a + 1][d];
                        d++;
                    }
                }
            }

            for(int a=3, d = 1, s=0; a<=5; a++){
                int c = 3;
                for(int b=0; b<=2; b++){
                    if(a==5){
                        d = 0;
                        i[c][s] = i[b][d];
                        c++;
                    }else {
                        i[c][s] = i[b][d];
                        c++;
                    }
                }d++;
                s++;
            }

            //  part-5
            for(int a=3, d = 4, s=3; a<=5; a++){
                int c = 3;
                for(int b=0; b<=2; b++){
                    if(a==5){
                        d = 3;
                        i[c][s] = i[b][d];
                        c++;
                    }else {
                        i[c][s] = i[b][d];
                        c++;
                    }
                }d++;
                s++;
            }

            int sd3 = 1, sd4 = 2;
            for(int a=0; a<=5; a++){
                int sp = i[sd3][a];
                i[sd3][a] = i[sd4][a];
                i[sd4][a] = sp;
            }

            sd3 = 3; sd4 = 4;
            for(int a=0; a<=5; a++){
                int sp = i[sd3][a];
                i[sd3][a] = i[sd4][a];
                i[sd4][a] = sp;
            }

            sd3 = 1; sd4 = 2;
            for(int a=0; a<=5; a++){
                int sp = i[a][sd3];
                i[a][sd3] = i[a][sd4];
                i[a][sd4] = sp;
            }

            sd3 = 3; sd4 = 4;
            for(int a=0; a<=5; a++){
                int sp = i[a][sd3];
                i[a][sd3] = i[a][sd4];
                i[a][sd4] = sp;
            }

            Random random1 = new Random();
            boolean port1 = false;
            for(int a=0; a<6; a++){
                for(int b=0; b<6; b++){
                    ans[a][b] = i[a][b];

                if(levelController.level.equals("Easy")) {
                    soundManager.playSound("easy");
                    if(random1.nextInt(3)<1) {
                        i[a][b] = 0; counter++;
                        if(counter>36){
                            port1 = true;
                            break;
                        }
                    }
                }else if(levelController.level.equals("Medium")) {
                    soundManager.playSound("medium");
                    if(random1.nextInt(5)<=1) {
                        i[a][b] = 0; counter++;
                        if(counter>36){
                            port1 = true;
                            break;
                        }
                    }
                }
                }

                if(port1){
                    break;
                }
            }



            tf_0_0.setText(model.checkZero(i[0][0]));
            tf_0_1.setText(model.checkZero(i[0][1]));
            tf_0_2.setText(model.checkZero(i[0][2]));
            tf_0_3.setText(model.checkZero(i[0][3]));
            tf_0_4.setText(model.checkZero(i[0][4]));
            tf_0_5.setText(model.checkZero(i[0][5]));

            tf_1_0.setText(model.checkZero(i[1][0]));
            tf_1_1.setText(model.checkZero(i[1][1]));
            tf_1_2.setText(model.checkZero(i[1][2]));
            tf_1_3.setText(model.checkZero(i[1][3]));
            tf_1_4.setText(model.checkZero(i[1][4]));
            tf_1_5.setText(model.checkZero(i[1][5]));

            tf_2_0.setText(model.checkZero(i[2][0]));
            tf_2_1.setText(model.checkZero(i[2][1]));
            tf_2_2.setText(model.checkZero(i[2][2]));
            tf_2_3.setText(model.checkZero(i[2][3]));
            tf_2_4.setText(model.checkZero(i[2][4]));
            tf_2_5.setText(model.checkZero(i[2][5]));

            tf_3_0.setText(model.checkZero(i[3][0]));
            tf_3_1.setText(model.checkZero(i[3][1]));
            tf_3_2.setText(model.checkZero(i[3][2]));
            tf_3_3.setText(model.checkZero(i[3][3]));
            tf_3_4.setText(model.checkZero(i[3][4]));
            tf_3_5.setText(model.checkZero(i[3][5]));

            tf_4_0.setText(model.checkZero(i[4][0]));
            tf_4_1.setText(model.checkZero(i[4][1]));
            tf_4_2.setText(model.checkZero(i[4][2]));
            tf_4_3.setText(model.checkZero(i[4][3]));
            tf_4_4.setText(model.checkZero(i[4][4]));
            tf_4_5.setText(model.checkZero(i[4][5]));

            tf_5_0.setText(model.checkZero(i[5][0]));
            tf_5_1.setText(model.checkZero(i[5][1]));
            tf_5_2.setText(model.checkZero(i[5][2]));
            tf_5_3.setText(model.checkZero(i[5][3]));
            tf_5_4.setText(model.checkZero(i[5][4]));
            tf_5_5.setText(model.checkZero(i[5][5]));

        }


    public void newGame(ActionEvent actionEvent) throws IOException {
        if(levelController.level.equals("Easy")){

            soundManager.stopSound("easy");
            loadNewGame(actionEvent);}
        else if (levelController.level.equals("Medium")){
            soundManager.stopSound("medium");
            loadNewGame(actionEvent);
        }
    }
    public void loadNewGame(ActionEvent actionEvent) throws IOException {
        Parent parent =
                FXMLLoader.load(getClass().getResource("/static/level.fxml"));
        Scene scene = new Scene(parent);
        Stage stage =
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void message(ActionEvent actionEvent) throws IOException {
        Parent parent =
                FXMLLoader.load(getClass().getResource("/static/GameOver.fxml"));
        Scene scene = new Scene(parent);
        Stage stage =
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    private void message2(ActionEvent actionEvent) throws IOException {
        Parent parent =
                FXMLLoader.load(getClass().getResource("/static/WinGame.fxml"));
        Scene scene = new Scene(parent);
        Stage stage =
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void btn_result(ActionEvent actionEvent) throws IOException {

        getUserInput();

        int joy = 0;
        for(int a=0; a<6; a++){
            for(int b=0; b<6; b++){
                if(i[a][b]==ans[a][b]){
                    joy++;
                }

            }
        }

        if (joy == 36) {

            if(levelController.level.equals("Easy")){

            soundManager.stopSound("easy");
            soundManager.playnormalSound("win");
            message2(actionEvent);}
            if(levelController.level.equals("Medium")){

                soundManager.stopSound("medium");
                soundManager.playnormalSound("win");
                message2(actionEvent);}



        } else {
            if(levelController.level.equals("Easy")){
            soundManager.stopSound("easy");
            soundManager.playnormalSound("lose");
            message(actionEvent);}

        if(levelController.level.equals("Medium")){
            soundManager.stopSound("medium");
            soundManager.playnormalSound("lose");
            message(actionEvent);}
    }
    }

    @FXML
    void loadGame(ActionEvent event) {

    }
    @FXML
    void btn_offVolume(ActionEvent event) {
        if(levelController.level.equals("Easy")){
        soundManager.stopSound("easy");}

        else if(levelController.level.equals("Medium")){
            soundManager.stopSound("medium");}
    }

    @FXML
    void btn_onVolume(ActionEvent event) {
        if(levelController.level.equals("Easy")){
        soundManager.playSound("easy");
        }
        else if(levelController.level.equals("Medium")){
            soundManager.playSound("medium");
        }


    }

}