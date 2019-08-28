package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scanner.*;
import symbols.*;
class ScannerTest {
	
	private Scanner scanner;
	private List<Symbol> result;
	
	@BeforeEach
	void setUp() throws Exception {
		this.scanner = new Scanner();
		this.result = new ArrayList<Symbol>();
		}

	@Test
	void expr1   /*1231*/  () {
		result = new ArrayList<Symbol>();
		result.add(new NaturalNumber(123));
		assertEquals(result, scanner.toSymbolSequence("123"));
	}
	
	@Test
	void expr2  /**123**/  () {
		result.add(new NaturalNumber(123));
		assertEquals(result, scanner.toSymbolSequence("123 "));
	}
	
	@Test
	void expr3  /**1+64*8**/  () {
		result.add(new NaturalNumber(1));
		result.add( PlusOp.getInstance());
		result.add(new NaturalNumber(64));
		result.add(MultOp.getInstance());
		result.add(new NaturalNumber(8));
		assertEquals(result, scanner.toSymbolSequence("1+64*8"));
	}
	@Test
	void expr4  /**+15++*8**/  () {
		result.add(PlusOp.getInstance());
		result.add(new NaturalNumber(15));
		result.add(PlusOp.getInstance());
		result.add(PlusOp.getInstance());
		result.add(MultOp.getInstance());
		result.add(new NaturalNumber(8));
		assertEquals(result, scanner.toSymbolSequence("+15++*8"));
	}
	@Test
	void expr5 /**(8+7a*23)**/(){
	result.add(BracketOpen.getInstance());	
	result.add(new NaturalNumber(8));
	result.add(PlusOp.getInstance());
	result.add(new NaturalNumber(7));
	result.add(new ErrorToken('a'));
	result.add(MultOp.getInstance());
	result.add(new NaturalNumber(23));
	result.add(BracketClose.getInstance());
	assertEquals(result, scanner.toSymbolSequence("(8+7a*23)"));	
	}
	@Test
	void expr6  /**3 3**/  () {
		result.add(new NaturalNumber(3));
		result.add(new NaturalNumber(3));
		assertEquals(result, scanner.toSymbolSequence("3 3"));
	}
	
}
