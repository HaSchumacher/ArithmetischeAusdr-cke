package Expression;

public class Produkt implements Summand {
	/**
	 * Ein Produkt besteht mindestens aus einem Faktor.
	 * Der Faktor kann mit dem Operator '*' und einem Expression Ausdruck erweitert werden.
	 **/
	private Faktor factor2;
	private Summand summand1;
	
	public Produkt(Faktor factor2, Summand summand1) {
		super();
		this.factor2 = factor2;
		this.summand1 = summand1;
	}



	@Override
	public Integer evaluate() {
		Integer result = factor2.evaluate() * summand1.evaluate();
		return result;
	}
	public String toString() {
		return summand1.toString() + "*" + factor2.toString();
	}
	
}
