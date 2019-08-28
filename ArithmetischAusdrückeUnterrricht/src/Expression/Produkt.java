package Expression;

public class Produkt implements Summand {
	/**
	 * Ein Produkt besteht mindestens aus einem Faktor.
	 * Der Faktor kann mit dem Operator '*' und einem Expression Ausdruck erweitert werden.
	 **/
	private Expression factor2;
	private Expression summand1;
	
	public Produkt(Expression expr, Expression expression) {
		super();
		this.factor2 = expr;
		this.summand1 = expression;
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
