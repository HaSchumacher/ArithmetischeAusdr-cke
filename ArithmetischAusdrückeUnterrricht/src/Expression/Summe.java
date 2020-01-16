package Expression;

import BinaryOperation.Addition;
import Parser.SymbolParserException;
import View_and_Controller.TreeVisitor;
import symbols.PlusOp;
import symbols.Symbol;

public class Summe implements Expression{
	/**
	 * Eine Summe besteht aus mindestens einem Summanten. 
	 * Erweitert kann der Summand mit der Operator '+' und einem Expression Ausdurck.   
	 **/
	private Expression content1;
	private Expression content2;
	
	
	public Summe(Expression summand1 , Expression expression) {
		super();
		this.content1 = summand1;
		this.content2 = expression;
	}

	@Override
	public Integer evaluate() throws SymbolParserException{
		return Addition.INSTANCE.calculate(this.content1, this.content2);
	}

	@Override
	public void accept(TreeVisitor v) {
		v.handle(this);
		
	}

	public Expression getcontent1() {
		return content1;
	}

	public Expression getcontent2() {
		return content2;
	}

	@Override
	public Symbol getop() {
		return PlusOp.getInstance();
	}
	public String toString() {
		return "Summe";
		
	}
		

}
