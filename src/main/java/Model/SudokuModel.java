/* Name: Hoang Ngoc Quynh Anh
 Purpose: This game, called Soduku (female edition), includes five levels: easy, medium, hard, expert, and evil.
 The 6x6 sodoku game's easy and medium levels require players to fill in each row and column from 1 to 6.
 This level is intended for novices and features a smaller grid that is simpler to understand and solve.
 If you're new to Sudoku or just want a short and entertaining challenge, this is ideal for you.
 On the other hand, level hard, expert, evil is a 9x9 sodoku game designed for players who want to push their mental
 limits and find it somewhat more difficult to complete the puzzles. Players must fill each row and column from 1 to 9.
*/
package Model;

import Controllers.levelController;

import java.io.*;
import java.util.Random;

public class SudokuModel {
    private int[][] i;
    private int[][] ans;
    private int counter;
    private String messageResult;
    public SudokuModel(){
        i = new int[9][9];
        ans = new int[9][9];
        counter = 0;
        messageResult = null;

    }
    public int[][] getI() {
        return i;
    }

    public int[][] getAns() {
        return ans;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getMessageResult() {
        return messageResult;
    }

    public void setMessageResult(String messageResult) {
        this.messageResult = messageResult;
    }

    public void initializeGrids() {
        for(int a = 0; a < 9; a++) {
            for(int b = 0; b < 9; b++) {
                i[a][b] = 0;
                ans[a][b] = 0;
            }
        }
    }
    public int emptyChecker(String s){
        int sm = 0;
        for(int a=0; a<s.length(); a++){
            if(s.charAt(a)>='0' && s.charAt(a)<='9') {
                sm = (sm * 10) + Character.getNumericValue(s.charAt(a));
            }
        }
        return sm;
    }
    public String checkZero(int n){
        return n==0 ? " " : String.valueOf(n);
    }


}
