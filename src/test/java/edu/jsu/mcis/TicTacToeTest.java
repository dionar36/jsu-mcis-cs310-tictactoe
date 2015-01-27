package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	private TicTacToe game;
	
	@Before
	public void startTest(){
		game = new TicTacToe();
	}
	
	@Test
	public void testGameBoardToSeeIfIsEmpty(){
		for(int row = 0; row < game.getNumbersOfRow(); row++){
			for(int colum = 0; colum < game.getNumbersOfColum(); colum++){
				assertEquals(TicTacToe.MarkABoard.EMPTY, game.markLocation(row,colum));
			}
		}
	}
	
	@Test
	public void testlocationOfMarkInBoard(){
		game.markAtThisLocation(1,1);
		assertEquals(TicTacToe.MarkABoard.X, game.markLocation(1,1));
		game.markAtThisLocation(0,1);
		assertEquals(TicTacToe.MarkABoard.O, game.markLocation(0,1));
		game.markAtThisLocation(0,0);
		assertEquals(TicTacToe.MarkABoard.X, game.markLocation(0,0));
		game.markAtThisLocation(0,2);
		assertEquals(TicTacToe.MarkABoard.O, game.markLocation(0,2));
		game.markAtThisLocation(2,2);
		assertEquals(TicTacToe.MarkABoard.X, game.markLocation(2,2));
	
	}
	
	@Test
	public void testWinnerDiagonally(){
		
		//assertEquals("X is the winner", game. messegerX());
		//assertEquals(TicTacToe.MarkABoard.X, game.winningDiagonally());
		//assertTrue("O", false);
		//assertEquals(TicTacToe.MarkABoard.X, game.boardIsMark(1,1));
		//assertEquals(TicTacToe.MarkABoard.X, game.boardIsMark(2,2));
		
		
	}
	
	@Test
	public void testWinnerHotizontally(){
		
	}
	
	@Test
	public void testWinnerVertical(){
		
	}
	
	@Test
	public void testForTie(){
		
	}
	
	@Test 
	public void testForceATie(){
		
	}
	
}