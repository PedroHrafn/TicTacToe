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
} 