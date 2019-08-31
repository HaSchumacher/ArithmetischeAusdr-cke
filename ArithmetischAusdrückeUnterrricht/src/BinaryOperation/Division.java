package BinaryOperation;

import Expression.Expression;
import Parser.SymbolParserException;

public class Division implements BinaryOperation {
	public static final Division INSTANCE = new Division();
	
	private Division() {
	}
	@Override
	public Integer calculate(Expression x1, Expression x2) throws SymbolParserException {
		return x1.evaluate() / x2.evaluate();
	}

}
