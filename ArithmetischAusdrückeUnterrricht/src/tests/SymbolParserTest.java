package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Expression.Expression;
import Expression.Produkt;
import Parser.ExpressionParser;
import Parser.SymbolParser;
import scanner.Scanner;
import symbols.NaturalNumber;
import symbols.Symbol;

class SymbolParserTest {
	
	private SymbolParser parser;
	private Expression currentexpr;
	private Scanner scanner;
	
	@BeforeEach
	void setUp() throws Exception {
	this.currentexpr = new Produkt(new NaturalNumber(3), new NaturalNumber(3));
	this.parser = new ExpressionParser();
	this.scanner = new Scanner();
	
	}
	@Test
	void testSum() {
		List<Symbol> scan = this.scanner.toSymbolSequence("3*3");
		System.out.println(scan);
		System.out.println(currentexpr.evaluate());
		System.out.println(this.parser.toExpression(scan).evaluate());
		assertEquals(currentexpr.evaluate(),this.parser.toExpression(scan).evaluate());
	}

	

}
