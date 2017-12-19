package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args)throws InterruptedException {
	// write your code here

        //board state
        new boardState();


        for(int i = 0; i<boardState.board.length; i++) {
            for(int j = 0; j<boardState.board.length; j++) {
                System.out.print(boardState.board[i][j]);
                Thread.sleep(210);
            }
            System.out.println();

        }

        Scanner move = new Scanner(System.in);
        System.out.println("Please input the coordinates of your move with 0,0 being the top left and 2,2 being the bottom right.\nex.  1,1 or 0,2");
        String in = move.next();
        String[] str = in.split(",");
        for(int i = 0; i < str.length; i++) {
            boardState.uMove[i] = Integer.parseInt(str[i]);
        }
        boardState.userMove(boardState.uMove[0], boardState.uMove[1]);

        System.out.println("Thinking...");

        Thread.sleep(2000);

        boardState.cpuMove();


    }
}
