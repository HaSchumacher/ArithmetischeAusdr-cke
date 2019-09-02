package Expression;

import Parser.SymbolParserException;

public class Substraction implements Expression {
	private Expression subtrahend1;
	private Expression minuent2;
	
	public Substraction(Expression subtrahend1, Expression minuent2) {
		super();
		this.subtrahend1 = subtrahend1;
		this.minuent2 = minuent2;
	}
	@Override
	public Integer evaluate() throws SymbolParserException {
		
		return BinaryOperation.Substraktion.INSTANCE.calculate(subtrahend1, minuent2);
	}

}
