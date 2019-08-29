package symbols;

import Parser.SymbolParserException;
import Parser.SymbolVisitor;

public class EndofInput implements Symbol {

	@Override
	public void accept(SymbolVisitor v) throws SymbolParserException {
		 v.handle(this);
		
	}

	

	}
