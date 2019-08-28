package symbols;

import Parser.SymbolVisitor;
import basic.TextConstants;

public class PlusOp implements Symbol {
	private static PlusOp theonlyplus = new PlusOp();
	private PlusOp() {
		
	}
	public static PlusOp getInstance() {
		return theonlyplus;
	}
	public String toString() { return TextConstants.Plusop;}
	
	public void accept(SymbolVisitor v) {
		v.handle(this);
		
	}
}
