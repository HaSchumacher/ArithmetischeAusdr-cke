package BinaryOperation;

import Expression.Expression;
import Parser.SymbolParserException;

public class Division implements BinaryOperation {
	public static final Division INSTANCE = new Division();
	
	private Division() {
	}
	@Override
	public Integer calculate(Expression x1, Expression x2) throws SymbolParserException {
		if (x2.evaluate() != 0 ) {return x2.evaluate() / x1.evaluate();}
		else {throw new SymbolParserException("Division durch 0 nicht erlaubt!");}
	}

}
