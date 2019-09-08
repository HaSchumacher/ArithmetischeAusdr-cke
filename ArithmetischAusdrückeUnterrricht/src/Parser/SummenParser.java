package Parser;

import java.util.List;

import Expression.Divident;
import Expression.Expression;
import symbols.Symbol;

public class SummenParser extends SymbolParser{

	
	/**
	 * Der Summen Parser wertet Summenexpressions aus.
	 * Der SpParser wird vom ExpParser und ruft den FakParser auf.
	 **/
	public Expression toExpression(List<Symbol> symbols) throws SymbolParserException {
		Divident divident = (Divident) new DividendParser().toExpression(symbols);
		SummandVisitor summandvisitor = new SummandVisitor(divident, symbols);
		symbols.get(0).accept(summandvisitor);
		return summandvisitor.getExpr();
	}
	

}
