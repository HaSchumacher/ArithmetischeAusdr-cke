package Parser;

import java.util.List;

import Expression.Expression;
import symbols.EndofInput;
import symbols.Symbol;

public class ExpressionParser extends SymbolParser{
	
	/**
	 * Der Expression Parser wertet die Expressions aus.
	 * Dabei delegiert er die Auswertung auf verschiedene Parser.
	 **/
	public Expression toExpression(List<Symbol> symbols) throws SymbolParserException{
		symbols.add( new EndofInput());
		Expression expr = new SummenParser().toExpression(symbols);
		ExprVisitor expressionvisitor = new ExprVisitor(expr, symbols);
		symbols.get(0).accept(expressionvisitor);
		return expressionvisitor.getExpr(); 
		}
		
	
	

}
