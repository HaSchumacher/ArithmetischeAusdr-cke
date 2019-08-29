package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Parser.ExpressionParser;
import Parser.SymbolParserException;
import scanner.Scanner;

class SymbolParserTest {
	
	@Test
	void testSum() throws SymbolParserException {
		
		assertEquals(10, new ExpressionParser().toExpression(new Scanner().toSymbolSequence ("5+5")).evaluate());
	}

	

}
