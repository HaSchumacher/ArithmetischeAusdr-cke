package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Parser.SymbolParser;
import scanner.Scanner;

class SymbolParserTest {
	
	private SymbolParser parser;
	@BeforeEach
	void setUp() throws Exception {
		
	}
	@Test
	void testSum() {
		
		assertEquals(10,this.parser.toExpression(new Scanner().toSymbolSequence("5+5")).evaluate());
	}

	

}
