package symbols;

import Parser.SymbolParserException;
import Parser.SymbolVisitor;
import basic.TextConstants;

public class Division implements Symbol {

	private static Division theonlydiv = new Division();
	private Division() {
		
	}
	public static Division getInstance() {
		return theonlydiv;
	}
	public String toString() { return TextConstants.Plusop;}
	
	public void accept(SymbolVisitor v) throws SymbolParserException {
		v.handle(this);
		
	}

}
