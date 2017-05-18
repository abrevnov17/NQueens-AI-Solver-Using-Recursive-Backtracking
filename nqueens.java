//nQueens solution set
//Devin Ohlson
//Zach Mazlish
//Toly Brevnov
 
import java.util.*;

public class nqueens{

	static final int size=8;

	public static void main(String[] args){
		int[][] board = new int[size][size];
		solve(board);
	}


	public static void solve(int[][] board){
		//Initiates recursive function
		//Tries different starting positions
		for(int i=0; i<board.length; i++){
			helper(board,i,0);
		}
	}

	public static void helper(int[][] board, int a, int b){
		//Checks for base cases
		if (b==board.length-1&&check(board,a,b)){
			board[a][b]=1;
			print(board);
			System.out.println("");
		}
		if (check(board, a, b)==false){
		}

		else{
			//Recursion happens
			//Loops through each possible place in a column
			int[][] copy=copy(board);
			copy[a][b]=1;
			if (b<copy.length-1){
				for(int y=0; y<copy.length;y++){
					helper(copy, y, b+1);
				}
			}
			
		}
	}

	//Checks for openings
	public static boolean check(int[][] board, int a, int b){
		for (int x=0;x<board[0].length;x++){
		//Horizontals
			if (board[x][b]==1 && x!=a){
				return false;
			}

		}
		//Verticals
		for (int y=0;y<board[0].length;y++){
			if (board[a][y]==1 && y!=b){
				return false;
			}
		}
		//Diagonals
		for (int x=0;x<board[0].length;x++){

			for (int y=0;y<board[0].length;y++){
				if (board[x][y]==1 && Math.abs(x-a)==Math.abs(y-b)){
					return false;
				}
			}
		}
  		return true;
	}

	public static int[][] copy(int[][] input){

		int[][] output = new int[input[0].length][input[0].length];
		for(int i=0; i<input[0].length; i++){
			for(int j=0; j<input[0].length; j++){
				output[i][j]=input[i][j];
			}
		}
		return output;
	}


	public static void print(int[][] input){
		for(int i=0; i<input[0].length; i++){
			for(int j=0; j<input[0].length; j++){
				System.out.print(input[i][j]+" ");
			}
			System.out.println("");
		}
	}


}
