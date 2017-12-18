package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //board state
        new boardState();

        for(int i = 0; i<boardState.board.length; i++)
        {
            for(int j = 0; j<boardState.board.length; j++)
            {
                System.out.print(boardState.board[i][j]);
            }
            System.out.println();
        }



    }
}
