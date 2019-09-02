package Expression;

import Parser.SymbolParserException;

public class Division implements Summand {

	
	private Expression divisor;
	private Expression divident;
	
	public Division(Expression divisor, Expression divident) {
		super();
		this.divident = divident;
		this.divisor = divisor;
		
	}
	@Override
	public Integer evaluate() throws SymbolParserException {
		return BinaryOperation.Division.INSTANCE.calculate(divisor, divident);
	}

}
