package symbols;

import Parser.SymbolParserException;
import Parser.SymbolVisitor;
import basic.TextConstants;

public class MinOp implements Symbol {

	private static MinOp theonlysub = new MinOp();
	private MinOp() {
		
	}
	public static MinOp getInstance() {
		return theonlysub;
	}
	public String toString() { return TextConstants.Minusop;}
	
	public void accept(SymbolVisitor v) throws SymbolParserException {
		v.handle(this);}
}
