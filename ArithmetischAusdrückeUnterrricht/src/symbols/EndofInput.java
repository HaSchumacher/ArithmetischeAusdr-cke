package symbols;

import Parser.SymbolVisitor;

public class EndofInput implements Symbol {

	@Override
	public void accept(SymbolVisitor v) {
		 v.handle(this);
		
	}

	

	}
