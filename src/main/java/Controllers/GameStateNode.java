package Controllers;

import java.util.ArrayList;
import java.util.List;

public class GameStateNode {
    private int[][] grid;
    private GameStateNode parent;
    private List<GameStateNode> children;

    public GameStateNode(int[][] grid) {
        this.grid = grid;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public GameStateNode(int[][] grid, GameStateNode parent) {
        this.grid = grid;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public GameStateNode getParent() {
        return parent;
    }

    public void setParent(GameStateNode parent) {
        this.parent = parent;
    }

    public List<GameStateNode> getChildren() {
        return children;
    }

    public void addChild(GameStateNode child) {
        this.children.add(child);
    }
}
