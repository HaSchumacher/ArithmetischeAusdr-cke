package symbols;

import Parser.SymbolParserException;
import Parser.SymbolVisitor;
import Expression.Faktor;
public class NaturalNumber implements Symbol, Faktor {
	private final Integer value;
	
	public NaturalNumber(Integer value) {
		this.value = value;
	}

		
	@Override
	public boolean equals(Object obj) {// Object entspricht Anything ,return
										// beendet die Methode
		if (obj == null)
			return false;
		if (!(obj instanceof NaturalNumber))
			return false;
		NaturalNumber other = (NaturalNumber) obj; // Anpassung obj als
													// NaturalNumber
													// (Typanpassung)
		return this.value.equals(other.value);
	}

	@Override
	public String toString() {
		return value.toString();
	}
	@Override
	public void accept(SymbolVisitor v) throws SymbolParserException {
		v.handle(this);
		
	}

	@Override
	public Integer evaluate() {
		return this.value;
	}

}