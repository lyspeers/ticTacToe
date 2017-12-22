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
    public static void userMove(int y, int x){
        if(move%2 == 0) {
            board[y][x] = "o ";
            userL = "o ";
        }else{
            board[y][x] = "x ";
            userL = "x ";
        }
        for(int i = 0; i<boardState.board.length; i++) {
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


        if(move == 1){
            System.out.println("I will take (0,0)");
            board[0][0] = "x ";
            cpuL = "x ";
        }
        else if(move == 2){
            if(board[1][1].equals("- ")){
                System.out.println("I will take (1,1)");
                board[1][1] = "o ";
            }else{
                System.out.println("I will take (0,2)");
                board[0][2] = "o ";
            }

            cpuL = "o ";


        }


        if(move > 2) {
            cMove = check2();
            System.out.println("I will take(" + cMove[0] + "," + cMove[1] + ")");
            board[cMove[0]][cMove[1]] = cpuL;
            //check for 2 in a row etc.
        }

        for(int i = 0; i<boardState.board.length; i++) {
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

            for(int k = 0;k<board.length;k++){
            for(int i=0;i<board.length;i++){
                if (!(board[k][i].equals(cpuL)) && !(board[k][i].equals("- "))) {
                    countU++;
                }else if((board[k][i].equals(cpuL)) && !(board[k][i].equals("- "))){
                        countC++;
                    }
                    if(countU == 2 && !(countC == 1)){
                        for(int j = 0;j<board.length;j++){
                            if(!(board[k][j].equals(userL)) && !(board[k][j].equals(cpuL))){
                                a[0] = k; a[1] = j;
                                System.out.println("row");
                                return a;
                            }

                        }
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
               if(countU == 2 && !(countC == 1)){
                   for(int j = 0;j<board.length;j++){
                       if(!(board[j][k].equals(userL)) && !(board[j][k].equals(cpuL))){
                           a[0] = j; a[1] = k;

                           System.out.println("Colom");
                           return a;
                       }

                   }
               }
           }
           countU = 0;
           countC = 0;
       }

       for(int k = 0;k<board.length;k++){
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
                           System.out.println("diagonal");
                           return a;
                       }
                       k++;
                       System.out.println(k);

                   }
               }
           }

       }

/*
       for(int k = 0;k<board.length;k++){
           for(int i=2;i>=0;i--){

               if (!(board[k][i].equals(cpuL)) && !(board[k][i].equals("- "))) {
                   countU++;
               }else if((board[k][i].equals(cpuL)) && !(board[k][i].equals("- "))){
                   countC++;
               }
               k++;
               if(countU == 2 && !(countC == 1)){
                   k = 0;
                   for(int j = 2;j>=0;j--){

                       if(!(board[k][j].equals(userL)) && !(board[k][j].equals(cpuL))){
                           a[0] = k; a[1] = j;
                           System.out.println("diagonal2");
                           return a;
                       }
                       k++;
                       System.out.println(k);

                   }
               }
           }

       }
       */
       System.out.println("dud");
       for(int k = 0;k<board.length;k++){
           for(int i=0;i<board.length;i++){

               if (!(board[k][i].equals(cpuL)) && !(board[k][i].equals(userL))) {
                   a[0] = k;a[1] = i;
               }
               }
           }


       return a;
        }

    private static boolean winCheck(){
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

        if(blank == 0)
            return true;

       return false;
    }
}


