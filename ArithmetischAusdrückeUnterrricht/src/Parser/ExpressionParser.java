package Parser;

import java.util.List;

import Expression.Expression;
import symbols.Symbol;

public class ExpressionParser extends SymbolParser {
	
	/**
	 * Der Expression Parser wertet die Expressions aus.
	 * Dabei delegiert er die Auswertung auf verschiedene Parser.
	 **/
	public Expression toExpression(List<Symbol> symbols) {
		super.setList(symbols);
		ExprVisitor expressionvisitor = new ExprVisitor(this);
		symbols.get(0).accept(expressionvisitor);
		return expressionvisitor.getExpr(); 
		}
		
	
	

}
