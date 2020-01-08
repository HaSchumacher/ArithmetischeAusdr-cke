package Expression;

import BinaryOperation.Division;
import Parser.SymbolParserException;
public class Div implements Summand {
	private Expression divident2;
	private Expression divisor1;
	
	public Div( Expression expr, Expression expression) {
		super();
		this.divisor1 = expr;
		this.divident2 = expression;
	
	}
	
	public Integer evaluate() throws SymbolParserException{
		return Division.INSTANCE.calculate(divisor1, divident2);
	}
}
