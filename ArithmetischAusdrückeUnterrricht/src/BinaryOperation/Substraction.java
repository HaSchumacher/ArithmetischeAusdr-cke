package BinaryOperation;

import Expression.Expression;
import Parser.SymbolParserException;

public class Substraction implements BinaryOperation {
	public static final Substraction INSTANCE = new Substraction();
	private Substraction() {
		
	}
	
	@Override
	public Integer calculate(Expression x1, Expression x2) throws SymbolParserException {
		return x1.evaluate() - x2.evaluate();
	}

}
