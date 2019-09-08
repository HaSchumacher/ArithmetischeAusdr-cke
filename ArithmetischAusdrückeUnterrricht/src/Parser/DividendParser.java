package Parser;

import java.util.List;
import Expression.Expression;
import Expression.Faktor;
import symbols.Symbol;

public class DividendParser extends SymbolParser {

	@Override
	public Expression toExpression(List<Symbol> symbols) throws SymbolParserException {
		Faktor factor =  (Faktor) new FactorParser().toExpression(symbols);
		DividendVisitor divvis = new DividendVisitor(factor, symbols);
		symbols.get(0).accept(divvis);
		return divvis.getExpr();
	}

}
