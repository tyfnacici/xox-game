package Game;

import java.util.Scanner;

public class XoX {
private static char currentPlayer = 'X';
	
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 GameExtends game = new GameExtends();
		 	game.initializeBoard();
	        game.printBoard();

	        while (true) {
	            System.out.print("Enter a row (0, 1, 2) for player " + currentPlayer + ": ");
	            int row = scanner.nextInt();
	            System.out.print("Enter a column (0, 1, 2) for player " + currentPlayer + ": ");
	            int col = scanner.nextInt();

	            if (game.placeMark(row, col,currentPlayer)) {
	            	game.printBoard();
	                if (game.isGameWon(currentPlayer)) {
	                    System.out.println("Player " + currentPlayer + " has won!");
	                    break;
	                }
	                if (game.isGameDrawn()) {
	                    System.out.println("The game is a draw.");
	                    break;
	                }
	                currentPlayer = game.switchPlayers(currentPlayer);
	            }
	        }
	}

}
abstract class matris {
	  static void initializeBoard() {
	        char[][] board = new char[3][3];
	        for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[0].length; j++) {
	                board[i][j] = ' ';
	            }
	        }
	    }
}
 class GameExtends extends matris{
	
	private static char[][] board;
	
	GameExtends(char[][] board){
		this.board = board;
	}
	GameExtends(){
		board = new char[3][3];
		 for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[0].length; j++) {
	                board[i][j] = ' ';
	            }
	        }
	}
	  static void printBoard() {
	        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
	        System.out.println("    --+-+--");
	        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
	        System.out.println("    --+-+--");
	        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
	        System.out.println("     0 1 2 ");
	    }

	     static boolean placeMark(int row, int col,char currentPlayer) {
	        if ((row >= 0) && (row < 3)) {
	            if ((col >= 0) && (col < 3)) {
	                if (board[row][col] == ' ') {
	                    board[row][col] = currentPlayer;
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

	     static boolean isGameWon(char player) {
	        // Check rows
	        for (int i = 0; i < 3; i++) {
	            if ((board[i][0] == player) && (board[i][1] == player) && (board[i][2] == player)) {
	                return true;
	            }
	        }

	        // Check columns
	        for (int j = 0; j < 3; j++) {
	            if ((board[0][j] == player) && (board[1][j] == player) && (board[2][j] == player)) {
	                return true;
	            }
	        }

	        // Check diagonals
	        if ((board[0][0] == player) && (board[1][1] == player) && (board[2][2] == player)) {
	            return true;
	        }
	        if ((board[2][0] == player) && (board[1][1] == player) && (board[0][2] == player)) {
	            return true;
	        }

	        return false;
	    }

	     static boolean isGameDrawn() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[i][j] == ' ') {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	     static char switchPlayers(char currentPlayer) {
	        if (currentPlayer == 'X') {
	            return 'O';
	        } else {
	            return 'X';
	        }
	    }
	
	
}
