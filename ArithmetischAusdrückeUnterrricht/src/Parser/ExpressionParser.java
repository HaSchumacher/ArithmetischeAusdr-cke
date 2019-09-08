package Parser;

import java.util.List;

import Expression.Expression;
import symbols.Symbol;

class ExpressionParser extends ExpressionParserProxy{
	
	/**
	 * Der Expression Parser wertet die Expressions aus.
	 * Dabei delegiert er die Auswertung auf verschiedene Parser.
	 **/
	
	public Expression toExpression(List<Symbol> symbols) throws SymbolParserException{
		Expression Minuend =  new MinuendParser().toExpression(symbols);
		MinuendVisitor minvis = new MinuendVisitor(Minuend, symbols);
		symbols.get(0).accept(minvis);
		return minvis.getExpr();
		
		
		}
		
	
	

}
