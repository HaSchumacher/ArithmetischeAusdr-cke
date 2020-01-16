package Expression;

import BinaryOperation.Division;
import Parser.SymbolParserException;
import View_and_Controller.TreeVisitor;
import symbols.DivOp;
import symbols.Symbol;
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

	@Override
	public void accept(TreeVisitor v) {
		v.handle(this);
	}

	@Override
	public Expression getcontent1() {
		return divisor1;
	}

	@Override
	public Expression getcontent2() {
		return divident2;
	}

	@Override
	public Symbol getop() {
		return DivOp.getInstance();
	}
	public String toString() {
		return "Division";
	}
}
