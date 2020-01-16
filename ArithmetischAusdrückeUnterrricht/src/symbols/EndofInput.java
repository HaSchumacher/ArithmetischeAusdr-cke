package symbols;

import Parser.SymbolParserException;
import Parser.SymbolVisitor;

public class EndofInput implements Symbol {
	
	private static final EndofInput INSTANCE = new EndofInput();
	
	private EndofInput() {
		
	}
	public static EndofInput getInstance() {
		return INSTANCE;
	}
	@Override
	public void accept(SymbolVisitor v) throws SymbolParserException {
		 v.handle(this);
		
	}
}
