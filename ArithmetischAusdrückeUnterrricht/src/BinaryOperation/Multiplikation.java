package BinaryOperation;

import Expression.Expression;
import Parser.SymbolParserException;

public class Multiplikation implements BinaryOperation {
	public static final Multiplikation INSTANCE = new Multiplikation();
	private Multiplikation() {
		
	}
	@Override
	public Integer calculate(Expression x1, Expression x2) throws SymbolParserException {
		return x1.evaluate() * x2.evaluate();
	}
	
}
