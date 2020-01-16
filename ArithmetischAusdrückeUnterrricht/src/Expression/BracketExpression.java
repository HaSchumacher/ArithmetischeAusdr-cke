package Expression;

import Parser.SymbolParserException;
import View_and_Controller.TreeVisitor;
import symbols.Symbol;

public class BracketExpression implements Faktor{
	private Expression expr;
	/**
	 *Ein Klammerausdruck umschließt eine Expression.
	 *Dabei muss jede geöffnete Klammer auch wieder geschlossen werden!  
	 **/

	public BracketExpression(Expression expr) {
		this.expr = expr;
	}
	public Expression getExpr() {
		return expr;
	}
	@Override
	public Integer evaluate() throws SymbolParserException{
		return this.expr.evaluate();
	}
	@Override
	public void accept(TreeVisitor v) {
		v.handle(this);
		
	}
	public Expression getcontent1() {
		return null;
	}
	@Override
	public Expression getcontent2() {
		return null;
	}
	@Override
	public Symbol getop() {
		return null;
	}
		
	
}
