package Expression;

import BinaryOperation.Addition;
import Parser.SymbolParserException;

public class Summe implements Subtrahend{
	/**
	 * Eine Summe besteht aus mindestens einem Summanten. 
	 * Erweitert kann der Summand mit der Operator '+' und einem Expression Ausdurck.   
	 **/
	private Subtrahend summand1;
	private Expression summand2;
	
	public Summe(Subtrahend summand1 , Expression expression) {
		super();
		this.summand1 = summand1;
		this.summand2 = expression;
	}

	@Override
	public Integer evaluate() throws SymbolParserException{
		return Addition.INSTANCE.calculate(this.summand1, this.summand2);
	}
	

}
