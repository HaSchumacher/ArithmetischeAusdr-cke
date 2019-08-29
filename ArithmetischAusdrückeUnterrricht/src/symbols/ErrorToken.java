package symbols;

import Parser.SymbolParserException;
import Parser.SymbolVisitor;

public class ErrorToken implements Symbol {

	private Character err;
	public ErrorToken(Character c) {
	 	this.err = c;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorToken other = (ErrorToken) obj;
		if (err == null) {
			if (other.err != null)
				return false;
		} else if (!err.equals(other.err))
			return false;
		return true;
	}

	@Override
	public void accept(SymbolVisitor v) throws SymbolParserException {
		v.handle(this);
		
	}
	public String toString() { return err.toString(); }
}

