package Expression;

import BinaryOperation.Multiplikation;
import Parser.SymbolParserException;

public class Produkt implements Divident {
	/**
	 * Ein Produkt besteht mindestens aus einem Faktor.
	 * Der Faktor kann mit dem Operator '*' und einem Expression Ausdruck erweitert werden.
	 **/
	private Expression factor2;
	private Divident summand1;
	
	public Produkt(Expression expr, Divident expression) {
		super();
		this.factor2 = expr;
		this.summand1 = expression;
	}

	@Override
	public Integer evaluate() throws SymbolParserException {
		return Multiplikation.INSTANCE.calculate(this.summand1, this.factor2);
	}
	
	
}
