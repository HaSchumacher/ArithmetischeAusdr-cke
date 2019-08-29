package Expression;

import Parser.SymbolParserException;

public interface Expression {

	public Integer evaluate() throws SymbolParserException;
	
}
