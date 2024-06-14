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
