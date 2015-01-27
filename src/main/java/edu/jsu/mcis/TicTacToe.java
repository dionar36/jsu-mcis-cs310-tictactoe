package edu.jsu.mcis;

public class TicTacToe {
	
	public enum MarkABoard {EMPTY,X,O}
	public MarkABoard[][] boardIsMarkOrNot = new MarkABoard [3][3];
	public boolean turn = true;
	
	
	public int getNumbersOfRow(){
		for(int r = 0; r < boardIsMarkOrNot.length; r++){
			for(int c =0; c < boardIsMarkOrNot.length; c++){
				boardIsMarkOrNot[r][c] = MarkABoard.EMPTY;
			}
		}
		return 3;
	}
	
	public int getNumbersOfColum(){
		for(int r = 0; r < boardIsMarkOrNot.length; r++){
			for(int c =0; c < boardIsMarkOrNot.length; c++){
				boardIsMarkOrNot[r][c] = MarkABoard.EMPTY;
			}
		}
		return 3;
	}
	
	public MarkABoard markLocation(int r, int c){
		return boardIsMarkOrNot[r][c];
	}
	
	public void markAtThisLocation(int r, int c){
		if(turn == true){
			boardIsMarkOrNot[r][c] = MarkABoard.X;
			winningDiagonall(r, c);
			//System.out.println(messegerX());
			turn = false;
		}
		else{
			boardIsMarkOrNot[r][c] = MarkABoard.O;
			winningDiagonall (r, c);
			//System.out.println(messegerO());
			turn = true;
		}
	}
	
	public MarkABoard boardIsMark(int row, int colum){
		return boardIsMarkOrNot[row][colum];
	}
	
	public String messegerX(){
		return "X is the winner";
	}
	
	public String messegerO(){
		return "O is the winner";
	}
	
	public boolean winningDiagonall (int r, int c){
		//boardIsMarkOrNot[r][c];
		if(boardIsMarkOrNot[r][c] == boardIsMarkOrNot[0][0] || boardIsMarkOrNot[1][1] == MarkABoard.X /*|| boardIsMarkOrNot[2][2] == MarkABoard.X*/){
			System.out.println(messegerX());
			
			return true;
			
		}
			return false;
			
		
	}
	

	
	
			 
}

