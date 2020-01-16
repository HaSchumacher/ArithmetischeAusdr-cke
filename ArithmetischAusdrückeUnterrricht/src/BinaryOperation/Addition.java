package BinaryOperation;

import Expression.Expression;
import Parser.SymbolParserException;

public class Addition implements BinaryOperation {
	public static final Addition INSTANCE = new Addition();
	
	private Addition() {
		
	}
	
	@Override
	public Integer calculate(Expression x1, Expression x2) throws SymbolParserException {
		return x1.evaluate() + x2.evaluate();
	}


}
