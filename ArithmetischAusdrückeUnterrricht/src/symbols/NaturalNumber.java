package symbols;

import Parser.SymbolParserException;
import Parser.SymbolVisitor;
import View_and_Controller.TreeVisitor;
import Expression.Expression;
import Expression.Faktor;
public class NaturalNumber implements Symbol, Faktor {
	private final Integer value;
	
	public NaturalNumber(Integer value) {
		this.value = value;
	}

		
	@Override
	public boolean equals(Object obj) {// Object entspricht Anything ,return 
		if (obj == null)			   //beendet die Methode
			return false;
		if (!(obj instanceof NaturalNumber))
			return false;
		NaturalNumber other = (NaturalNumber) obj; // Anpassung obj als
													// NaturalNumber
													// (Typanpassung)
		return this.value.equals(other.value);
	}

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


	@Override
	public void accept(TreeVisitor v) {
		v.handle(this);
	}


	@Override
	public Expression getcontent1() {
		return this;}
	public Expression getcontent2() {
		return this;}
	public Symbol getop() {
		return this;}
}