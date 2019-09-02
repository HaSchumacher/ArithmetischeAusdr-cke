package Parser;

import java.util.List;

import Expression.Expression;
import symbols.Symbol;

public class SummenParser extends SymbolParser{

	
	/**
	 * Der Summen Parser wertet Summenexpressions aus.
	 * Der SpParser wird vom ExpParser und ruft den FakParser auf.
	 **/
	public Expression toExpression(List<Symbol> symbols) throws SymbolParserException {
		Expression expr = new FactorParser().toExpression(symbols);
		SummandVisitor summandvisitor = new SummandVisitor(expr, symbols);
		symbols.get(0).accept(summandvisitor);
		return summandvisitor.getExpr();
	}
	

}
