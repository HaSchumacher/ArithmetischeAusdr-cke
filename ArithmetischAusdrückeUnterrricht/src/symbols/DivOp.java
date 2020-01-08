package symbols;

import Parser.SymbolParserException;
import Parser.SymbolVisitor;
import basic.TextConstants;

public class DivOp implements Symbol {

	private static DivOp theonlydiv = new DivOp();
	private DivOp() {
		
	}
	public static DivOp getInstance() {
		return theonlydiv;
	}
	public String toString() { return TextConstants.Divop;}
	
	public void accept(SymbolVisitor v) throws SymbolParserException {
		v.handle(this);
		
	}
	

}
