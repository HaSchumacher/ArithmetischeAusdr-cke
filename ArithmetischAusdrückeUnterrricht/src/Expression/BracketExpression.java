package Expression;

import Parser.SymbolParserException;

public class BracketExpression implements Faktor{
	private Expression expr;
	/**
	 *Ein Klammerausdruck umschlie�t eine Expression.
	 *Dabei muss jede ge�ffnete Klammer auch wieder geschlossen werden!  
	 **/

	public BracketExpression(Expression expr) {
		this.expr = expr;
	}
	@Override
	public Integer evaluate() throws SymbolParserException{
		return this.expr.evaluate();
	}
		
	
}
