package symbols;

import Parser.SymbolVisitor;
import basic.TextConstants;

public class BracketClose implements Symbol{

	private static BracketClose theonlyBclose = new BracketClose();
	private BracketClose() {
		
	}

	public static BracketClose getInstance() {
		return theonlyBclose;
	}
	public String toString() { return TextConstants.Bracketclose;}

	public void accept(SymbolVisitor v) {
		v.handle(this);
		
	}
}
