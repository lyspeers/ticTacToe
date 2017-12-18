package com.company;

/**
 * Created by ls059 on 12/18/17.
 */
public class boardState {
    public static String [][] board;
    public boardState(){

        board = new String[3][3];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                board[i][j] = "x ";
            }
        }
    }
    public static void userMove(int x, int y){

    }

}
