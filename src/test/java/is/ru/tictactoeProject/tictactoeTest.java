package is.ru.tictactoeProject;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class tictactoeTest {
	@Test
	public void testInitializeBoard() {

		tictactoe game = new tictactoe();

		char cmp[][] = new char[3][3];

		for (int i = 0; i < 3 ; i++ ) {

			for (int j = 0; j < 3 ; j++ ) {

				cmp[i][j] = '-';
			}
		}

		assertEquals(cmp, game.getBoard());
	}

	@Test
	public void testIsFullOnEmptyBoard() {
		tictactoe game = new tictactoe();
		assertEquals(false, game.isFull());
	}

	@Test
	public void testPlaceMarkTwice() {

		tictactoe game = new tictactoe();
		assertEquals(true, game.placeMark(0,1));
		assertEquals(false, game.placeMark(0,1));
	}
	@Test
	public void testPlaceMarkOutSideOfBoard() {

		tictactoe game = new tictactoe();
		assertEquals(false, game.placeMark(3,3));
	}
	@Test
	public void testPlaceMarkSuccess() {

		tictactoe game = new tictactoe();
		assertEquals(true, game.placeMark(1,1));
		assertEquals(true, game.placeMark(2,1));
		assertEquals(true, game.placeMark(2,0));
		assertEquals(true, game.placeMark(0,2));
		assertEquals(true, game.placeMark(2,2));

	}
	@Test
	public void testPlaceMarkFillBoard() {

	tictactoe game = new tictactoe();
	for (int i = 0; i < 3 ; i++ ) {

			for (int j = 0; j < 3 ; j++ ) {

					assertEquals(true, game.placeMark(i,j));
				}
			}
	}

	@Test
	public void testChangePlayer()
	{
		tictactoe game = new tictactoe();
		assertEquals('x',game.getPlayer());
		game.changePlayer();
		assertEquals('o',game.getPlayer());
	}

	@Test
	public void testChangePlayerBackToSamePlayer()
	{
		tictactoe game = new tictactoe();
		assertEquals('x',game.getPlayer());
		game.changePlayer();
		assertEquals('o',game.getPlayer());
		game.changePlayer();
		assertEquals('x',game.getPlayer());
		
	}

	@Test
	public void testIsFullOnFullBoard(){
		tictactoe game = new tictactoe();
		char cmp[][] = new char[3][3];

		for (int i = 0; i < 3 ; i++ ) {

			for (int j = 0; j < 3 ; j++ ) {
				game.getPlayer();
				game.placeMark(i,j);
				game.changePlayer();
			}
		}
		assertEquals(true, game.isFull());
	}
	@Test
	public void testIsFullOnPartlyFullBoard(){
		tictactoe game = new tictactoe();
		char cmp[][] = new char[3][3];

		for (int i = 0; i < 2 ; i++ ) {

			for (int j = 0; j < 2 ; j++ ) {
				game.getPlayer();
				game.placeMark(i,j);
				game.changePlayer();
			}
		}
		assertEquals(false, game.isFull());
	}

	@Test
	public void testCheckIfSame() {
		tictactoe game = new tictactoe();
		assertEquals(false, game.checkIfSame('o', 'x', 'x'));
	}

} 