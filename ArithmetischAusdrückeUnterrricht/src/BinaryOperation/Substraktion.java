package BinaryOperation;

import Expression.Expression;
import Parser.SymbolParserException;

public class Substraktion implements BinaryOperation {
	public static final Substraktion INSTANCE = new Substraktion();
	private Substraktion() {
		
	}
	
	@Override
	public Integer calculate(Expression x1, Expression x2) throws SymbolParserException {
		return x2.evaluate() - x1.evaluate();
	}


}
