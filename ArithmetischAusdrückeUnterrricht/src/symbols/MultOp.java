package symbols;

import Parser.SymbolVisitor;
import basic.TextConstants;

public class MultOp implements Symbol {
	private static MultOp theOnlyMult = new MultOp();
	private MultOp() {
		
	}
	public static MultOp getInstance() {
		return theOnlyMult;
	}
	public String toString() { return TextConstants.Multop;}
	
	public void accept(SymbolVisitor v) {
		v.handle(this);
		
	}
}
