package com.company;

/**
 * Created by ls059 on 12/18/17.
 */
public class  boardState  {
    public static String [][] board;
    public static int move = 1;
    public static int[] uMove = new int[2];
    public static int[] cMove = new int[2];
    static String cpuL;
    static String userL;
    private static int countU = 0, countC = 0;

    public boardState(){

        board = new String[3][3];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                board[i][j] = "- ";
            }
        }
    }
    public static void userMove(int x, int y){
        if(!(board[x][y].equals("- "))){ //checks for valid move
        System.out.println("Invalid move.  Restarting");
        System.exit(1);
    }

        if(move%2 == 0) { //assigns the use a letter for the game
            board[x][y] = "o ";
            userL = "o ";
        }else{
            board[x][y] = "x ";
            userL = "x ";
        }
        for(int i = 0; i<boardState.board.length; i++) { //prints the board
            for(int j = 0; j<boardState.board.length; j++) {
                System.out.print(boardState.board[i][j]);
                try {
                    Thread.sleep(210);
                } catch (InterruptedException e) {
                }
            }
            System.out.println();
        }

        move++;
    }

    public static void cpuMove(){


        if(move == 1){ //decides optimal move
            System.out.println("I will take (0,0)");
            board[0][0] = "x ";
            cpuL = "x ";
        }
        else if(move == 2){ // decides optimal move
            if(board[1][1].equals("- ")){
                System.out.println("I will take (1,1)");
                board[1][1] = "o ";
            }else{
                System.out.println("I will take (0,2)");
                board[0][2] = "o ";
            }

            cpuL = "o ";


        }


        if(move > 2) { // gets move from check to and makes it
            cMove = check2();
            if((board[cMove[0]][cMove[1]].equals(cpuL) || board[cMove[0]][cMove[1]].equals(userL))){ //checks for move validity
                System.out.println("Invalid move.  Restarting");
                System.exit(1);
            }
            System.out.println("I will take(" + cMove[0] + "," + cMove[1] + ")");
            board[cMove[0]][cMove[1]] = cpuL;
            //check for 2 in a row etc.
        }

        for(int i = 0; i<boardState.board.length; i++) { // prints board
            for(int j = 0; j<boardState.board.length; j++) {
                System.out.print(boardState.board[i][j]);
                try {
                    Thread.sleep(210);
                } catch (InterruptedException e) {

                }
            }
            System.out.println();
        }

        move++;


    }

    private static int[] check2(){
       int[] a = new int[2];
       countU = 0; countC = 0;

        for(int k = 0;k<board.length;k++){ // checks if any rows have 2 of the user's letter in them
            for(int i=0;i<board.length;i++){
                if (!(board[k][i].equals(cpuL)) && !(board[k][i].equals("- "))) {
                    countU++;
                }else if((board[k][i].equals(cpuL)) && !(board[k][i].equals("- "))){
                    countC++;
                }
                if(countU == 2 && !(countC == 1)){ // checks for when there are 2 letters in a row
                    for(int j = 0;j<board.length;j++){
                        if(!(board[k][j].equals(userL)) && !(board[k][j].equals(cpuL))){ // sends the coordinates of the open space in a row to the computer to select as its move
                            a[0] = k; a[1] = j;
                            System.out.println((a[0] + a[1]));
                            return a;
                        }

                    }
                }
            }
            countU = 0;
            countC = 0;
        }

       for(int k = 0;k<board.length;k++){// same as above for columns
           for(int i=0;i<board.length;i++){
               if ((board[i][k].equals(userL))) {
                   countU++;
               }else if(!(board[i][k].equals(userL)) && !(board[i][k].equals("- "))){
                   countC++;
               }
               if(countU == 2 && !(countC == 1)){
                   for(int j = 0;j<board.length;j++){
                       if(!(board[j][k].equals(userL)) && !(board[j][k].equals(cpuL))){
                           a[0] = j; a[1] = k;
                           System.out.println((a[0] + a[1]));
                           return a;
                       }

                   }
               }
           }

           countU = 0;
           countC = 0;
       }

       for(int k = 0;k<board.length;k++){ // same as above but for diagonals
           for(int i=0;i<board.length;i++){

               if (!(board[k][i].equals(cpuL)) && !(board[k][i].equals("- "))) {
                   countU++;
               }else if((board[k][i].equals(cpuL)) && !(board[k][i].equals("- "))){
                   countC++;
               }
               k++;
               if(countU == 2 && !(countC == 1)){
                   k = 0;
                   for(int j = 0;j<board.length;j++){

                       if(!(board[k][j].equals(userL)) && !(board[k][j].equals(cpuL))){
                           a[0] = k; a[1] = j;
                           System.out.println((a[0] + a[1]));
                           return a;
                       }
                       k++;
                       System.out.println(k);

                   }
               }
           }

       }
       random:
       for(int k = 0;k<board.length;k++){
           for(int i=0;i<board.length;i++){

               if (!(board[k][i].equals(cpuL)) && !(board[k][i].equals(userL))) {
                   a[0] = k;a[1] = i;
                   double j = Math.random();
                   if(j < .5)
                    break random;
               }
               }
           }


       return a;
        }

    public static boolean winCheck(){
    countC = 0; countU = 0;int blank = 0;

        for(int k = 0;k<board.length;k++){
            for(int i=0;i<board.length;i++){
                if (!(board[k][i].equals(cpuL)) && !(board[k][i].equals("- "))) {
                    countU++;
                }else if((board[k][i].equals(cpuL)) && !(board[k][i].equals("- "))){
                    countC++;
                }
                else{
                    blank++;
                }
                if(countU == 3 ){
                    System.out.println("Congratulations you beat the machine");
                    return true;
                }else if(countC == 3){
                    System.out.println("Better luck next time");
                    return true;
                }
            }
            countU = 0;
            countC = 0;
        }

        for(int k = 0;k<board.length;k++){
            for(int i=0;i<board.length;i++){
                if (!(board[i][k].equals(cpuL)) && !(board[i][k].equals("- "))) {
                    countU++;
                }else if((board[i][k].equals(cpuL)) && !(board[i][k].equals("- "))){
                    countC++;
                }
                else{
                    blank++;
                }
                if(countU == 3 ){
                    System.out.println("Congratulations you beat the machine");
                    return true;
                }else if(countC == 3){
                    System.out.println("Better luck next time");
                    return true;
                }
            }
            countU = 0;
            countC = 0;
        }

        for(int k = 0;k<board.length;k++) {
            for (int i = 0; i < board.length; i++) {

                if (!(board[k][i].equals(cpuL)) && !(board[k][i].equals("- "))) {
                    countU++;
                } else if ((board[k][i].equals(cpuL)) && !(board[k][i].equals("- "))) {
                    countC++;
                } else {
                    blank++;
                }
                if(countU == 3 ){
                    System.out.println("Congratulations you beat the machine");
                    return true;
                }else if(countC == 3){
                    System.out.println("Better luck next time");
                    return true;
                }
                k++;

            }
        }

        if(blank == 0) {
            System.out.println("Oops it's a tie");
            return true;
        }

       return false;
    }
}


