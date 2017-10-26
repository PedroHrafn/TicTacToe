package is.ru.tictactoeProject;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class tictactoeTest {
	@Test
	public void testEmptyString() {
		assertEquals(0, tictactoe.Add(""));
	}
	@Test
	public void testOneNumber() {
		assertEquals(1, tictactoe.Add("1"));
		assertEquals(2, tictactoe.Add("2"));
	}
} 