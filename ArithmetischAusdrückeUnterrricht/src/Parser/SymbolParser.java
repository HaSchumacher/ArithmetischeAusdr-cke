package Parser;

import java.util.List;

import Expression.Expression;
import symbols.Symbol;

public abstract class SymbolParser {
	
	public abstract Expression toExpression (List<Symbol> symbols) throws SymbolParserException;

}
