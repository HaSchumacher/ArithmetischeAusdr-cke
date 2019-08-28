package symbols;

import Parser.SymbolVisitor;
import Expression.Faktor;
public class NaturalNumber implements Symbol, Faktor {
	private final Integer value;
	
	public NaturalNumber(Integer value) {
		this.setValue(value);
	}

		
	private void setValue(Integer value2) {
		// TODO Auto-generated method stub
		
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
	public void accept(SymbolVisitor v) {
		v.handle(this);
		
	}

	@Override
	public Integer evaluate() {
		return this.value;
	}

}