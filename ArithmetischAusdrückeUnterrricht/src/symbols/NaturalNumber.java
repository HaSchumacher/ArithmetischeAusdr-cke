package symbols;

import Parser.SymbolVisitor;
import Expression.Faktor;
public class NaturalNumber implements Symbol, Faktor {
	private Integer value;
	public NaturalNumber(Integer value) {
		this.setValue(value);
	}

	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
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
	public void accept(SymbolVisitor v) {
		v.handle(this);
		
	}

	@Override
	public Integer evaluate() {
		return this.value;
	}

}