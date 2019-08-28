package Parser;

import java.util.List;

import Expression.Expression;
import symbols.Symbol;

public class FactorParser extends SymbolParser {

	
		/**
	 * Der Produkt Parser wertet Produkt Expressions aus.
	 * Er wird von dem SpParser aufgerufen und ruft eventuell den ExpParser auf. 
	 **/
	public Expression toExpression(List<Symbol> symbols) {
		super.setList(symbols);
		FactorVisitor factorVisitor = new  FactorVisitor(this);
		symbols.get(0).accept(factorVisitor);
		return factorVisitor.getExpr();
	}
	
}
