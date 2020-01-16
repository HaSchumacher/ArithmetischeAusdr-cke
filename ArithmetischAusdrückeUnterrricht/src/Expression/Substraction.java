package Expression;

import Parser.SymbolParserException;
import View_and_Controller.TreeVisitor;
import symbols.MinOp;
import symbols.Symbol;

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
	@Override
	public void accept(TreeVisitor v) {
		v.handle(this);
	}
	@Override
	public Expression getcontent1() {
		return subtrahend1;
	}
	@Override
	public Expression getcontent2() {
		return minuent2;
	}
	@Override
	public Symbol getop() {
		return MinOp.getInstance();
	}
	public String toString() {
		return "Subtraktion";
	}

}
