package Expression;

import Parser.SymbolParserException;

public class Division implements Summand {

	
	private Divident divident;
	private Expression divisor;
	
	
	public Division(Expression divident, Expression divisor) {
		super();
		this.divident = (Divident) divident;
		this.divisor = divisor;
		
	}
	@Override
	public Integer evaluate() throws SymbolParserException {
		return BinaryOperation.Division.INSTANCE.calculate(divisor, divident);
	}

}
