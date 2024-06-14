/* Name: Hoang Ngoc Quynh Anh
 Purpose: This game, called Soduku (female edition), includes five levels: easy, medium, hard, expert, and evil.
 The 6x6 sodoku game's easy and medium levels require players to fill in each row and column from 1 to 6.
 This level is intended for novices and features a smaller grid that is simpler to understand and solve.
 If you're new to Sudoku or just want a short and entertaining challenge, this is ideal for you.
 On the other hand, level hard, expert, evil is a 9x9 sodoku game designed for players who want to push their mental
 limits and find it somewhat more difficult to complete the puzzles. Players must fill each row and column from 1 to 9.
*/
package Controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class navigationManager {
    private static final Stack<Scene> forwardStack = new Stack<>();
    private static final Stack<Scene> backStack = new Stack<>();
    private static Stage primaryStage;

    public static void initialize(Stage stage) {
        primaryStage = stage;
    }

    public static void navigateTo(Scene newScene) {
        if (primaryStage.getScene() != null) {
           backStack.push(primaryStage.getScene());
        }
        forwardStack.clear();
        primaryStage.setScene(newScene);
    }

    public static void goBack() {
        // when we go back the forward stack will push the current screen to the forward stack
        // and then it show the screen that currently in the backstack
        if (!backStack.isEmpty()) {
           forwardStack.push(primaryStage.getScene());
           primaryStage.setScene(backStack.pop());
        }
    }
    public static void goForwrad(){
        // when we go foward the back stack will push the current screen to the backstack
        // and then it show the screen that currently in the forwardstack
        if(!forwardStack.isEmpty()){
            backStack.push(primaryStage.getScene());
            primaryStage.setScene(forwardStack.pop());
        }
    }
}
