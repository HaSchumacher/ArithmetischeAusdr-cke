package symbols;

import Parser.SymbolParserException;
import Parser.SymbolVisitor;
import basic.TextConstants;

public class Subtraction implements Symbol {

	private static Subtraction theonlysub = new Subtraction();
	private Subtraction() {
		
	}
	public static Subtraction getInstance() {
		return theonlysub;
	}
	public String toString() { return TextConstants.Plusop;}
	
	public void accept(SymbolVisitor v) throws SymbolParserException {
		v.handle(this);}
}
