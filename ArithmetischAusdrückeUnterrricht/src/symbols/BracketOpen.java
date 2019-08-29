package symbols;

import Parser.SymbolParserException;
import Parser.SymbolVisitor;
import basic.TextConstants;

public class BracketOpen implements Symbol{

	private static BracketOpen theonlyBopen = new BracketOpen();
	private BracketOpen() {
		
	}

	public static BracketOpen getInstance() {
		return theonlyBopen;
	}
	public String toString() { return TextConstants.Bracketopen;}
	@Override
	public void accept(SymbolVisitor v) throws SymbolParserException {
		v.handle(this);
		
	}
}
