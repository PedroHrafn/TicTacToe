package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class CalculatorTest {
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.Add(""));
	}
	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.Add("1"));
		assertEquals(2, Calculator.Add("2"));
	}
	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.Add("1,2"));
		assertEquals(2, Calculator.Add("1,1"));
	}
	@Test
	public void testManyNumbers() {
		assertEquals(7, Calculator.Add("1,2,4"));
		assertEquals(10, Calculator.Add("1,2,3,4"));
		assertEquals(20, Calculator.Add("5,10,3,2"));
	}
	@Test
	public void testNewLinesSplit() {
		assertEquals(3, Calculator.Add("1\n2"));
		assertEquals(20, Calculator.Add("5\n10,3\n2"));
	}

	@Test
	public void testOneNegativeNumberException() {
    	try {
	    	Calculator.Add("-1");
	    	junit.framework.Assert.fail("Negatives should throw exception");
		}
		catch(IllegalArgumentException e) {
			final String expected = "Negatives not allowed: -1";
	        assertEquals( expected, e.getMessage());
		}
	}
	@Test
	public void testManyNegativeNumberException() {
	    try {
	        Calculator.Add("-1,2,-9\n-2,8,-11,-3");
	        junit.framework.Assert.fail("Negatives should throw exception");
	    } 
	    catch (Exception e) {
	        final String expected = "Negatives not allowed: -1,-9,-2,-11,-3";
	        assertEquals( expected, e.getMessage());
	    } 
	}
	@Test
	public void testBiggerThan1K() {
		assertEquals(2, Calculator.Add("1001,2"));
	}
	@Test
	public void testnewDelimiterSemiKomma() {
		assertEquals(3, Calculator.Add("//;\n1;2"));
	} 
	@Test
	public void testnewDelimiterTwoSemiKommas() {
		assertEquals(4, Calculator.Add("//;;\n1;;2;;1"));
	} 
	@Test
	public void testnewDelimiterNegNumberException() {
		try {
			assertEquals(3, Calculator.Add("//;\n-1;2"));
			junit.framework.Assert.fail("Negatives should throw exception");
		}
		catch(IllegalArgumentException e) {
			final String expected = "Negatives not allowed: -1";
	        assertEquals( expected, e.getMessage());
		}
		
	} 
} 