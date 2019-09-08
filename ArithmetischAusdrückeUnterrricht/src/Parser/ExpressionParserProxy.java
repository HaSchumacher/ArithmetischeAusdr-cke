package Parser;

import java.util.List;

import Expression.Expression;
import symbols.EndofInput;
import symbols.Symbol;

public class ExpressionParserProxy extends SymbolParser {
	/*Fügt der Liste das EndOfInput Symbol hinzu und wertet die Symbol-Liste aus.*/
	
	public Expression toExpression(List<Symbol> symbols) throws SymbolParserException {
		symbols.add(new EndofInput());
		return new ExpressionParser().toExpression(symbols);
	}

}
