package Parser;

import java.util.List;

import Expression.Expression;
import symbols.Symbol;

public class MinuendParser extends SymbolParser {

	@Override
	public Expression toExpression(List<Symbol> symbols) throws SymbolParserException {
		Expression Minuend = new SummenParser().toExpression(symbols);
		MinuendVisitor minvis = new MinuendVisitor(Minuend, symbols);
		symbols.get(0).accept(minvis);
		return minvis.getExpr();
	}

}
