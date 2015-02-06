package edu.jsu.mcis;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Font;

public class TicTacToe {
	
	public TicTacToe() {
		reset();
		setButton();	
	}

	public enum Mark {EMPTY,X,O}
	public enum Result {NONE, X_WINS, O_WINS, TIE}
	private Mark[][] location = new Mark [3][3];
	private JButton[][] tiles = new JButton[3][3];
	private boolean playerTurn = true;
	private int row;
	private int col;
	
	public static void main(String[]args){
		TicTacToe board = new TicTacToe();
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3,3));
		frame.setSize(600,600);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				frame.add(board.tiles[i][j]);
			}
		}
		frame.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {
		public ButtonListener(int i, int j) {
			row = i;
			col = j;	
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			buttonClicked(row, col);
		}
	}
	
	private void buttonClicked(int row, int col) {
		
	}
	
	public void setButton(){
	for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
			tiles[i][j] = new JButton("");
			tiles[i][j].setLabel("");
			tiles[i][j].addActionListener(new ButtonListener(i, j));	
			}
		}
	}
	
	public void reset(){
		for(int row = 0; row < 3; row++){
			for(int colum = 0; colum < 3; colum++){
				location[row][colum] = Mark.EMPTY;
			}
		}
		playerTurn = true;
	}
	
	public void setMarkAt(int r, int c){
		if(playerTurn == true){
			location[r][c] = Mark.X;
			playerTurn = false;
		}
		else{
			location[r][c] = Mark.O;
			playerTurn = true;
		}
	}
	
	public Mark getMarkAt(int r, int c){
		return location[r][c];
	}
	
	private Result winnerDiagonally(){
		Result winner;
		if(location[0][0] == location[1][1] && 
		   location[0][0] == location[2][2] && 
		   location[0][0] != Mark.EMPTY){
			if (getMarkAt(0,0) == Mark.X){
				winner = Result.X_WINS;
			}
			else {winner = Result.O_WINS;}
		}
		else if (location[0][2]==location[1][1] &&
				 location[0][2]==location[2][0] && 
				 location[0][2]!= Mark.EMPTY){
			if (getMarkAt(0,2) == Mark.X){
				winner = Result.X_WINS;
			}
			else {winner = Result.O_WINS;}
		}
		else {winner = Result.NONE;}
		return winner;
	}
	
	private Result winnerHorizontally(){
		Result winner;
		if(location[0][0]==location[0][1] &&
		   location[0][0]==location[0][2] &&
		   location[0][0]!=Mark.EMPTY){
			if (getMarkAt(0,0) == Mark.X){
				winner = Result.X_WINS;
			}
			else {winner = Result.O_WINS;}
		}
		else if (location[1][0]==location[1][1] &&
				 location[1][0]==location[1][2] && 
				 location[1][1]!= Mark.EMPTY){
			if (getMarkAt(1,0) == Mark.X){
				winner = Result.X_WINS;
			}
			else {winner = Result.O_WINS;}
		}
		else if (location[2][0]==location[2][1] && 
				 location[2][0]==location[2][2] && 
				 location[2][1]!=Mark.EMPTY){
			if (getMarkAt(2,0) == Mark.X){
				winner = Result.X_WINS;
			}
			else {winner = Result.O_WINS;}
		}
		else {winner = Result.NONE;}
		return winner;
	}
	
	private Result winnerVertical(){
		Result winner;
		if(location[0][0]==location[1][0] &&
		   location[0][0]==location[2][0] &&
		   location[0][0]!=Mark.EMPTY){
			if (getMarkAt(0,0) == Mark.X){
				winner = Result.X_WINS;
			}
			else {winner = Result.O_WINS;}
		}
		else if (location[0][1]==location[1][1] &&
				 location[0][1]==location[2][1] && 
				 location[0][1]!= Mark.EMPTY){
			if (getMarkAt(1,0) == Mark.X){
				winner = Result.X_WINS;
			}
			else {winner = Result.O_WINS;}
		}
		else if (location[2][0]==location[2][1] && 
				 location[2][0]==location[2][2] && 
				 location[2][1]!=Mark.EMPTY){
			if (getMarkAt(2,0) == Mark.X){
				winner = Result.X_WINS;
			}
			else {winner = Result.O_WINS;}
		}
		else {winner = Result.NONE;}
		return winner;
	}
	
	public Result forTie(){
		return Result.TIE;
	}
	
	public Result getWinner() {
		Result diagonalWinner = winnerDiagonally();
		Result horizontalWinner = winnerHorizontally();
		Result verticalWinner = winnerVertical();
		
		if (diagonalWinner == Result.X_WINS || 
			horizontalWinner == Result.X_WINS){
			return Result.X_WINS;
		}
		else if (diagonalWinner == Result.O_WINS || 
				 horizontalWinner == Result.O_WINS){
			return Result.O_WINS;
		}
		else{return Result.NONE;}
	}
	
}