package Expression;

import BinaryOperation.Multiplikation;
import Parser.SymbolParserException;
import View_and_Controller.TreeVisitor;
import symbols.MultOp;
import symbols.Symbol;

public class Produkt implements Summand {
	/**
	 * Ein Produkt besteht mindestens aus einem Faktor.
	 * Der Faktor kann mit dem Operator '*' und einem Expression Ausdruck erweitert werden.
	 **/
	private Expression factor2;
	private Expression summand1;
	
	public Produkt(Expression expr, Expression expression) {
		super();
		this.factor2 = expr;
		this.summand1 = expression;
	}

	@Override
	public Integer evaluate() throws SymbolParserException {
		return Multiplikation.INSTANCE.calculate(this.summand1, this.factor2);
	}

	@Override
	public void accept(TreeVisitor v) {
		v.handle(this);
		
	}

	@Override
	public Expression getcontent1() {
		return summand1;
	}

	@Override
	public Expression getcontent2() {
		return factor2;
	}

	@Override
	public Symbol getop() {
		return MultOp.getInstance();
	}
	public String toString() {
		return "Produkt";
	}
	
	
}
