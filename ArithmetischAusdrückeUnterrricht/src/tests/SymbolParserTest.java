package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import Parser.ExpressionParserProxy;
import Parser.SymbolParserException;
import scanner.Scanner;

class SymbolParserTest {
	public void setUp() {
		new Scanner();
		new ExpressionParserProxy();
		}
	@Test
	void test1() throws SymbolParserException {
		
		assertEquals(10, new ExpressionParserProxy().toExpression(new Scanner().toSymbolSequence ("5+5")).evaluate());
	}
	@Test
	void test2() throws SymbolParserException {
		assertEquals(22, new ExpressionParserProxy().toExpression(new Scanner().toSymbolSequence ("11+11")).evaluate());
	}
	@Test
	void test3() throws SymbolParserException {
		assertEquals(25, new ExpressionParserProxy().toExpression(new Scanner().toSymbolSequence ("5*5")).evaluate());
	}
	@Test
	void test4() throws SymbolParserException {
		assertEquals(30, new ExpressionParserProxy().toExpression(new Scanner().toSymbolSequence ("10*3")).evaluate());
	}
	@Test
	void test5() throws SymbolParserException {
		assertEquals(100, new ExpressionParserProxy().toExpression(new Scanner().toSymbolSequence ("(5+5)*(5+5)")).evaluate());
		}
	@Test
	void test6() throws SymbolParserException {
		
		assertEquals(10, new ExpressionParserProxy().toExpression(new Scanner().toSymbolSequence ("10")).evaluate());
	}
	
	

}
