package Expression;

import Parser.SymbolParserException;

public class BracketExpression implements Faktor{
	private Expression expr;
	/**
	 *Ein Klammerausdruck umschließt eine Expression.
	 *Dabei muss jede geöffnete Klammer auch wieder geschlossen werden!  
	 **/

	public BracketExpression(Expression expr) {
		this.expr = expr;
	}
	@Override
	public Integer evaluate() throws SymbolParserException{
		return this.expr.evaluate();
	}
		
	
}
