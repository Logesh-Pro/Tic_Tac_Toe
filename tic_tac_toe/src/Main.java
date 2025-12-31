//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board.length; col++){
                board[row][col]=' ';
            }
        }
        char player ='X';
        boolean gameOver = false;
        Scanner scan = new Scanner(System.in);
        int count = 0;
        while(!gameOver){
            printboard(board);
            if(count>=9){
                System.out.println("Match Draw");
                return;
            }
            System.out.print("Player " + player + " enter: ");
            int row = scan.nextInt();
            int col = scan.nextInt();
            if(board[row][col]==' '){
                count++;
                board[row][col] = player;
                gameOver = havewon(board, player);
                if(gameOver){
                    printboard(board);
                    System.out.print("Player "+player+" has won");
                }
                else{
//                    if(player == 'X'){
//                        player = 'O';
//                    }
//                    else{
//                        player = 'X';
//                    }
                    player = (player == 'X')? 'O': 'X';
                }
            }
            else{
                System.out.println("Invalid move");
            }
//            printboard(board);
        }
    }
    public static void printboard(char[][] board){
        System.out.println("-+---+---+---+-");
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board.length; col++){
                System.out.print(" | "+board[row][col]);
            }
            System.out.print(" |");
            System.out.println();
            System.out.println("-+---+---+---+-");
        }
    }
    public static boolean havewon(char[][] board, char player){
        for(int row=0; row<board.length; row++){
            if((board[row][0]==player && board[row][1]==player && board[row][2]==player) ||
                    (board[0][row]==player && board[1][row]==player && board[2][row]==player)) {
                return true;
            }
        }
        if((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)){
            return true;
        }
        return false;
    }
}